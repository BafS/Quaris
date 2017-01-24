package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.Event;
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

        ch.heigvd.quaris.api.dto.Event eventDTO = new ModelMapper().map(event, ch.heigvd.quaris.api.dto.Event.class);
        eventDTO.setApplication(event.getApp().getName());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ch.heigvd.quaris.api.dto.Event> request = new HttpEntity<>(eventDTO);

        ResponseEntity<ch.heigvd.quaris.api.dto.Event> response = restTemplate
                .exchange(url, HttpMethod.POST, request, ch.heigvd.quaris.api.dto.Event.class);

        return response.getStatusCode().equals(HttpStatus.CREATED);
    }
}
