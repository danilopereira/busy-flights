package com.travix.medusa.busyflights.services.crazyair;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.travix.medusa.busyflights.common.exceptions.CrazyAirException;
import com.travix.medusa.busyflights.config.ServicesConfigTest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by danilopereira on 15/03/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(ServicesConfigTest.class)
@EnableAsync
@TestPropertySource(locations = {"classpath:test-application.properties"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrazyAirServiceTest {

    @Autowired
    private CrazyAirService crazyAirService;

    @Rule
    public WireMockRule crazyWireMockRule = new WireMockRule(8888);

    @Test
    public void test001_GetFlights() throws CrazyAirException, ExecutionException, InterruptedException {
        crazyWireMockRule.stubFor(get(urlEqualTo("/flights?origin=LHR&destination=AMS&departureDate=2018-03-15&returnDate=2018-03-25&numberOfPassengers=4"))
        .willReturn(aResponse().withStatus(200)
        .withHeader("Content-type", "application/json").withBodyFile("crazyAirResponse.json")));

        CrazyAirRequest request = new CrazyAirRequest.CrazyAirRequestBuilder()
                .setDepartureDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .setOrigin("LHR")
                .setDestination("AMS")
                .setReturnDate(LocalDate.now().plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE))
                .setPassengerCount(4)
                .build();

        CompletableFuture<List<CrazyAirResponse>> flights = crazyAirService.getFlights(request);

        assertEquals(3, flights.get().size());
    }

}
