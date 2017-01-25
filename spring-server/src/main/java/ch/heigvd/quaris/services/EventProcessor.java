package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.*;
import ch.heigvd.quaris.models.Event;
import ch.heigvd.quaris.models.Rule;
import ch.heigvd.quaris.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    private final RuleRepository ruleRepository;

    private final BadgeRepository badgeRepository;

    private final ScaleRepository scaleRepository;

    private final PointRepository pointRepository;

    private final ElasticSearchService elasticSearchService;

    @Autowired
    public EventProcessor(
            EndUserRepository endUserRepository,
            RuleRepository ruleRepository,
            BadgeRepository badgeRepository,
            ScaleRepository scaleRepository,
            PointRepository pointRepository,
            ElasticSearchService els
    ) {
        this.endUserRepository = endUserRepository;
        this.ruleRepository = ruleRepository;
        this.badgeRepository = badgeRepository;
        this.scaleRepository = scaleRepository;
        this.pointRepository = pointRepository;
        this.elasticSearchService = els;
    }

    private boolean applyRuleAction(final Event event, String script) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        boolean result = false;

        // TODO sanitarise the script
        // TODO add timeout

        try {
            engine.eval("function funAction(identifier, event, scales, a, b, c, d) {\n" +
                    "var EventScriptsProcessor = Java.type('ch.heigvd.quaris.services.EventScriptsProcessor');\n" +
                    "var quaris = new EventScriptsProcessor(a, b, c, d);\n" +
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
                    endUserRepository, badgeRepository, scaleRepository, pointRepository
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

    private boolean testRuleCriteria(final Event eventModel, String criteria) {
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
    @Transactional(propagation = Propagation.REQUIRED)
    synchronized public void processEvent(Application application, Event event) {
        EndUser targetEndUser = event.getUser();

        // If user does not exists, we need to create a new "user" with this (id, application) tuple

        if (targetEndUser == null) {
            targetEndUser = new EndUser();
            targetEndUser.setApplication(application);
            targetEndUser.setIdInGamifiedApplication(event.getIdentifier());
            targetEndUser.setNumberOfEvents(0);
            endUserRepository.save(targetEndUser);

            event.setUser(targetEndUser);
        }

//        List<Rule> rules = ruleRepository.findByApplicationId(application.getId());
        List<Rule> rules = ruleRepository.findByApplicationName(application.getName());

        System.out.println("------" + application.getName());

        rules.parallelStream()
                // Filter rules if criteria is true
                .filter(rule -> this.testRuleCriteria(event, rule.getCriteria()))
                // Apply action
                .forEach(rule -> {
                    System.out.println("ACTION FOR " + rule.getName());
                    if (this.applyRuleAction(event, rule.getAction())) {
                        System.out.println("ACTION OK [" + rule.getName() + "]");
                        // TODO ?
                    }

                    elasticSearchService.addEventToElasticsearch(event);
                });

        System.out.println("[i] targetEndUser:: " + targetEndUser.getIdInGamifiedApplication());

        targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents() + 1);
    }
}
