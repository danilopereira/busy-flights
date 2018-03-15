package com.travix.medusa.busyflights.clients.crazyair;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.http.ResponseEntity;

/**
 * Created by danilopereira on 15/03/18.
 */
public interface CrazyAirClient {
    ResponseEntity<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest);
}
