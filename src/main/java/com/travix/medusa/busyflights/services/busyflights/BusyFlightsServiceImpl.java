package com.travix.medusa.busyflights.services.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.services.toughjet.ToughJetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Autowired
    private CrazyAirService crazyAirService;

    @Autowired
    private ToughJetService toughJetService;

    @Override
    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) {
        List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();

        //Get Flights from CrazyAir
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
        crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
        crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
        crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
        crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
        List<CrazyAirResponse> crazyAirFights = crazyAirService.getFights(crazyAirRequest);

        //Get Flights from ToughJet
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
        List<ToughJetResponse> toughJetFlights = toughJetService.getFlights(toughJetRequest);


        return busyFlightsResponses;
    }
}
