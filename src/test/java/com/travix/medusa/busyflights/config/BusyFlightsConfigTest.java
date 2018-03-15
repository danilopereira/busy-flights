package com.travix.medusa.busyflights.config;

import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClient;
import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClientImpl;
import com.travix.medusa.busyflights.clients.toughjet.ToughJetClient;
import com.travix.medusa.busyflights.clients.toughjet.ToughJetClientImpl;
import com.travix.medusa.busyflights.services.busyflights.BusyFlightsService;
import com.travix.medusa.busyflights.services.busyflights.BusyFlightsServiceImpl;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.services.toughjet.ToughJetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

/**
 * Created by danilopereira on 15/03/18.
 */
@Configuration
public class BusyFlightsConfigTest {
    @Bean
    public CrazyAirService crazyAirService(){
        return mock(CrazyAirService.class);
    }

    @Bean
    public ToughJetService toughJetService(){
        return mock(ToughJetService.class);
    }

    @Bean
    public BusyFlightsService busyFlightsService(){
        return new BusyFlightsServiceImpl();
    }
}
