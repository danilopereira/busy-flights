package com.travix.medusa.busyflights.web;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.busyflights.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
@RestController
public class BusyFlightsController {

    @Autowired
    BusyFlightsService busFlightsService;

    @GetMapping(value = "/v1/flights")
    public List<BusyFlightsResponse> getFlights(@Valid BusyFlightsRequest busyFlightsRequest){
        return busFlightsService.getFlights(busyFlightsRequest);
    }
}
