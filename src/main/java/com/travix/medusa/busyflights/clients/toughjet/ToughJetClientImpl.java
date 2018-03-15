package com.travix.medusa.busyflights.clients.toughjet;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by danilopereira on 15/03/18.
 */
public class ToughJetClientImpl implements ToughJetClient {

    private RestTemplate restTemplate;
    private String baseUrl;

    private static final String GET_FLIGHTS_URL_TEMPLATE = "/flights?from=%s&to=%s" +
            "&outBoundDate=%s&inboundDate=%s&numberOfAdults=%s";

    public ToughJetClientImpl(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public ResponseEntity<ToughJetResponse[]> getFlights(ToughJetRequest toughJetRequest) {
        String url = buildRequestUrl(toughJetRequest);
        return restTemplate.getForEntity(url, ToughJetResponse[].class);
    }

    private String buildRequestUrl(ToughJetRequest toughJetRequest) {
        String queryUrl = String.format(GET_FLIGHTS_URL_TEMPLATE, toughJetRequest.getFrom(),
                toughJetRequest.getTo(), toughJetRequest.getOutboundDate(), toughJetRequest.getInboundDate(), toughJetRequest.getNumberOfAdults());

        return baseUrl.concat(queryUrl);
    }
}
