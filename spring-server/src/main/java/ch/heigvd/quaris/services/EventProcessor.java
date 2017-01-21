package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.*;
import ch.heigvd.quaris.repositories.BadgeRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.repositories.EventRepository;
import ch.heigvd.quaris.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This service is uses to process events by evaluation javascript from each rule
 */
@Service
public class EventProcessor {

    private final EndUserRepository endUserRepository;

    private final EventRepository eventRepository;

    private final RuleRepository ruleRepository;

    private final BadgeRepository badgeRepository;

    @Autowired
    public EventProcessor(EndUserRepository endUserRepository, EventRepository eventRepository, RuleRepository ruleRepository, BadgeRepository badgeRepository) {
        this.endUserRepository = endUserRepository;
        this.eventRepository = eventRepository;
        this.ruleRepository = ruleRepository;
        this.badgeRepository = badgeRepository;
    }

    public void addBadge(String identifier, String badgeName) {
        System.out.println("[i] Add new badge tu user " + identifier);

        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        EndUser endUser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, identifier);
        Badge badge = badgeRepository.findByNameAndApplicationName(badgeName, targetApplicationName);

        if (endUser != null) {
//            if (!endUser.hasBadge(badge)) {
            endUser.getBadges().add(badge);

            endUser.getBadges().forEach(b -> {
                System.out.println(b.getName());
            });

//            }
            endUserRepository.save(endUser);
        }

        System.out.println("[i] Badge [" + badgeName + "] added to [" + identifier + "]!");
    }

    public void removeBadge(String badgeName) {

    }

    private boolean applyRuleAction(Event event, String script) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        boolean result = false;

        // TODO sanitariz the script

        try {
            engine.eval("function funAction(identifier, event, scales, a, b, c, d) {\n" +
                    "var Helper = Java.type('ch.heigvd.quaris.services.EventProcessor');\n" +
                    "var quaris = new Helper(a, b, c, d);\n" +
                    "print('identifier is: ' + identifier + ', replies:' + scales.replies);\n" +
                    "// quaris.addBadge(identifier, 'asd');\n" +
                    script + "\n" +
                    "}");

            Invocable invocable = (Invocable) engine;

            Map<String, Object> scales = new HashMap<>();
            scales.put("replies", 10);
            scales.put("level", 1250);

            result = (boolean) invocable.invokeFunction(
                    "funAction", event.getIdentifier(), event, scales,
                    endUserRepository, eventRepository, ruleRepository, badgeRepository // TODO can we do better ?
            );
        } catch (ScriptException e) {
            e.printStackTrace();
            System.out.println("[ERROR] Error in the script for action " + script);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    private boolean testRuleCriteria(Event eventModel, String criteria) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        boolean result = false;

        try {
            engine.eval("function funCriteria(user, event, scales) {\n" +
                    "print('event: '+event+' user is: ' + user + ', replies:' + scales.replies);\n" +
                    "return " + criteria + "\n" +
                    "}");

            Invocable invocable = (Invocable) engine;

            Map<String, Object> scales = new HashMap<>();
            scales.put("replies", 10);
            scales.put("level", 1250);

            Map<String, String> event = new HashMap<>();
            scales.put("indentifier", eventModel.getIdentifier());
            scales.put("type", eventModel.getType());
            // scales.put("payload", eventModel.getType());
            // scales.put("level", eventModel.getApp().getName());

            result = (boolean) invocable.invokeFunction("funCriteria", "Testuser", eventModel, scales);
        } catch (ScriptException e) {
            // e.printStackTrace();
            System.out.println("[ERROR] Error in the script");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Async
    @Transactional
    public void processEvent(Application application, Event event) {
        EndUser targetEndUser = event.getUser();

        if (targetEndUser == null) {
            // TODO org.modelmapper ?

            targetEndUser = new EndUser();
            targetEndUser.setApplication(application);
            targetEndUser.setIdInGamifiedApplication(event.getIdentifier());
            targetEndUser.setNumberOfEvents(0);
            endUserRepository.save(targetEndUser);
        }

//        List<Rule> rules = ruleRepository.findByApplicationId(application.getId());
        List<Rule> rules = ruleRepository.findByApplicationName(application.getName());

        System.out.println("----------" + application.getName());

        rules.parallelStream()
                // Filter rules if criteria is true
                .filter(rule -> this.testRuleCriteria(event, rule.getCriteria()))
                // Apply action
                .forEach(rule -> {
                    System.out.println("ACTION FOR " + rule.getName());
                    this.applyRuleAction(event, rule.getAction());
                });

        System.out.println("[i] targetEndUser:: " + targetEndUser.getIdInGamifiedApplication());

        targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents() + 1);

        event.setUser(targetEndUser);
        eventRepository.save(event);
    }
}
