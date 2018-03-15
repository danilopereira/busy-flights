package com.travix.medusa.busyflights.services.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.services.toughjet.ToughJetService;
import com.travix.medusa.busyflights.utils.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    public static final String CRAZY_FLIGHT_SUPPLIER = "Crazy Flight";
    public static final String TOUGH_JET_SUPPLIER = "Tough Jet";
    @Autowired
    private CrazyAirService crazyAirService;

    @Autowired
    private ToughJetService toughJetService;

    @Override
    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) throws Exception {
        List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();

        //Get Flights from CrazyAir
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest.CrazyAirRequestBuilder()
                .setDepartureDate(busyFlightsRequest.getDepartureDate())
                .setDestination(busyFlightsRequest.getDestination())
                .setOrigin(busyFlightsRequest.getOrigin())
                .setReturnDate(busyFlightsRequest.getReturnDate())
                .setPassengerCount(busyFlightsRequest.getNumberOfPassengers())
                .build();

        List<CrazyAirResponse> crazyAirFights = crazyAirService.getFights(crazyAirRequest).get();

        //Get Flights from ToughJet
        ToughJetRequest toughJetRequest = new ToughJetRequest.ToughJetRequestBuilder()
                .setFrom(busyFlightsRequest.getOrigin())
                .setInboundDate(busyFlightsRequest.getReturnDate())
                .setOutboundDate(busyFlightsRequest.getDepartureDate())
                .setTo(busyFlightsRequest.getDestination())
                .setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers())
                .build();
        List<ToughJetResponse> toughJetFlights = toughJetService.getFlights(toughJetRequest).get();

        busyFlightsResponses = combineResults(crazyAirFights, toughJetFlights);


        return busyFlightsResponses;
    }

    private List<BusyFlightsResponse> combineResults(List<CrazyAirResponse> crazyAirFights, List<ToughJetResponse> toughJetFlights) {
        List<BusyFlightsResponse> response = new ArrayList<>();

        crazyAirFights.forEach(crazyFlight->{
            BusyFlightsResponse busyFlight = new BusyFlightsResponse();

            busyFlight.setSupplier(CRAZY_FLIGHT_SUPPLIER);
            busyFlight.setAirline(crazyFlight.getAirline());
            busyFlight.setArrivalDate(DateConverter.convertISOLocalDateTimeToISODateTime(crazyFlight.getArrivalDate()));
            busyFlight.setDepartureDate(DateConverter.convertISOLocalDateTimeToISODateTime(crazyFlight.getDepartureDate()));
            busyFlight.setDepartureAirportCode(crazyFlight.getDepartureAirportCode());
            busyFlight.setDestinationAirportCode(crazyFlight.getDestinationAirportCode());
            busyFlight.setFare(new BigDecimal(crazyFlight.getPrice()));

            response.add(busyFlight);
        });

        toughJetFlights.forEach(toughJetFlight->{
            BusyFlightsResponse busyFlight = new BusyFlightsResponse();

            busyFlight.setSupplier(TOUGH_JET_SUPPLIER);
            busyFlight.setAirline(toughJetFlight.getCarrier());
            busyFlight.setArrivalDate(DateConverter.convertISOInstantToISODateTime(toughJetFlight.getOutboundDateTime()));
            busyFlight.setDepartureDate(DateConverter.convertISOInstantToISODateTime(toughJetFlight.getInboundDateTime()));
            busyFlight.setDepartureAirportCode(toughJetFlight.getDepartureAirportName());
            busyFlight.setDestinationAirportCode(toughJetFlight.getArrivalAirportName());
            busyFlight.setFare(new BigDecimal(calculateTotalPrice(toughJetFlight.getBasePrice(), toughJetFlight.getTax(), toughJetFlight.getDiscount())));

            response.add(busyFlight);
        });

        return response;
    }

    private double calculateTotalPrice(double basePrice, double tax, double discount) {
        double discountPercentage = discount/100;
        double valueWithDiscount = (basePrice - (basePrice * discountPercentage));
        return (valueWithDiscount+tax);
    }
}
