package com.travix.medusa.busyflights.clients.crazyair;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by danilopereira on 15/03/18.
 */
public class CrazyAirClientImpl implements CrazyAirClient {
    private RestTemplate restTemplate;
    private String baseUrl;

    private static final String GET_FLIGHTS_URL_TEMPLATE = "/flights?origin=%s&destination=%s&departureDate=%s&returnDate=%s&numberOfPassengers=%s";

    public CrazyAirClientImpl(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public ResponseEntity<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest) {
        String url = createRequestUrl(crazyAirRequest);
        return restTemplate.getForEntity(url, CrazyAirResponse.class);
    }

    private String createRequestUrl(CrazyAirRequest crazyAirRequest) {
        String queryUrl = String.format(GET_FLIGHTS_URL_TEMPLATE, crazyAirRequest.getOrigin(), crazyAirRequest.getDestination(),
                crazyAirRequest.getDepartureDate(), crazyAirRequest.getReturnDate(), crazyAirRequest.getPassengerCount());

        return baseUrl.concat(queryUrl);
    }
}
