package ch.heigvd.quaris.services;

import ch.heigvd.quaris.api.dto.AwardDTO;
import ch.heigvd.quaris.api.dto.BadgeDTO;
import ch.heigvd.quaris.api.dto.EventDTO;
import ch.heigvd.quaris.models.Badge;
import ch.heigvd.quaris.models.Event;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Fabien Salathe on 24.01.17.
 */
@Service
public class ElasticSearchService {

    final String ELASTIC_SEARCH_URL = "http://127.0.0.1:9200/";

    /**
     * Add a specific event to elasticsearch database
     *
     * @param event
     * @return if response is positive
     */
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean addEventToElasticsearch(final Event event) {
        final String url = ELASTIC_SEARCH_URL + event.getApp().getName() + "/events";


        EventDTO eventDTO = new ModelMapper().map(event, EventDTO.class);
        eventDTO.setApplication(event.getApp().getName());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<EventDTO> request = new HttpEntity<>(eventDTO);

        ResponseEntity<EventDTO> response = restTemplate
                .exchange(url, HttpMethod.POST, request, EventDTO.class);

        return response.getStatusCode().equals(HttpStatus.CREATED);
    }

    @Async
    public boolean addBadgeToElasticsearch(final Badge badge, final String appName) {
        final String url = ELASTIC_SEARCH_URL + appName + "/awards";

        BadgeDTO badgeDTO = new ModelMapper().map(badge, BadgeDTO.class);
        AwardDTO awardDTO = new ModelMapper().map(badge, AwardDTO.class);
        awardDTO.setApplication(appName);
        awardDTO.setBadge(badgeDTO);
        awardDTO.setCreatedAt(new DateTime());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AwardDTO> request = new HttpEntity<>(awardDTO);

        ResponseEntity<AwardDTO> response = restTemplate
                .exchange(url, HttpMethod.POST, request, AwardDTO.class);

        return response.getStatusCode().equals(HttpStatus.CREATED);
    }
}
