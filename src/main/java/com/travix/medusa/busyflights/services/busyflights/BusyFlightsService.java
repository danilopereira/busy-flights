package com.travix.medusa.busyflights.services.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
@Service
public interface BusyFlightsService {

    List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest);
}
