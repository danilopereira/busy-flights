package com.travix.medusa.busyflights.services.busyflights;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.travix.medusa.busyflights.config.BusyFlightsConfigTest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.services.busyflights.BusyFlightsService;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.services.toughjet.ToughJetService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by danilopereira on 15/03/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(BusyFlightsConfigTest.class)
@EnableAsync
public class BusyFlightsServiceTest {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @Autowired
    private CrazyAirService crazyAirService;

    @Autowired
    private ToughJetService toughJetService;

    @Rule
    public WireMockRule toughJetWireMockRule = new WireMockRule(9999);

    @Test
    public void testGetFlights() throws Exception {

        when(crazyAirService.getFlights(Matchers.any())).thenReturn(generateCrazyResponse());

        when(toughJetService.getFlights(Matchers.any())).thenReturn(generateToughJetService());

//
//        toughJetWireMockRule.stubFor(get(urlMatching("/flights.*"))
//                .willReturn(aResponse().withStatus(200)
//                        .withHeader("Content-type", "application/json").withBodyFile("toughJetResponse.json")));
//
        BusyFlightsRequest request = new BusyFlightsRequest();

        request.setDepartureDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        request.setReturnDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        request.setOrigin("LHR");
        request.setDestination("AMS");
        request.setNumberOfPassengers(4);

        List<BusyFlightsResponse> flights = busyFlightsService.getFlights(request);

        assertEquals(6, flights.size());
    }


    private CompletableFuture<List<ToughJetResponse>> generateToughJetService() throws IOException {
        List<ToughJetResponse> response = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        ToughJetResponse[] toughJetResponses = mapper.readValue(new File(getFileFromResource("__files/toughJetResponse.json")), ToughJetResponse[].class);
        for(int i = 0; i<toughJetResponses.length; i ++){
            response.add(toughJetResponses[i]);
        }

        return CompletableFuture.completedFuture(response);
    }

    private String getFileFromResource(String filePath) {
        return getClass().getClassLoader().getResource(filePath).getFile();
    }

    private CompletableFuture<List<CrazyAirResponse>> generateCrazyResponse() throws IOException {
        List<CrazyAirResponse> response = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        CrazyAirResponse[] toughJetResponses = mapper.readValue(new File(getFileFromResource("__files/crazyAirResponse.json")), CrazyAirResponse[].class);
        for(int i = 0; i<toughJetResponses.length; i ++){
            response.add(toughJetResponses[i]);
        }

        return CompletableFuture.completedFuture(response);
    }


}
