package com.travix.medusa.busyflights.config;

import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClient;
import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClientImpl;
import com.travix.medusa.busyflights.clients.toughjet.ToughJetClient;
import com.travix.medusa.busyflights.clients.toughjet.ToughJetClientImpl;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirService;
import com.travix.medusa.busyflights.services.crazyair.CrazyAirServiceImpl;
import com.travix.medusa.busyflights.services.toughjet.ToughJetService;
import com.travix.medusa.busyflights.services.toughjet.ToughJetServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * Created by danilopereira on 15/03/18.
 */
@Configuration
@TestPropertySource(locations = {"classpath:test-application.properties"})
public class ServicesConfigTest {
    @Value("${crazyAir.baseUrl}")
    private String crazyAirBaseUrl;

    @Value("${toughJet.baseUrl}")
    private String toughJetBaseUrl;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CrazyAirClient crazyAirClient(RestTemplate restTemplate){
        return new CrazyAirClientImpl(restTemplate, crazyAirBaseUrl);
    }

    @Bean
    public ToughJetClient toughJetClient(RestTemplate restTemplate){
        return new ToughJetClientImpl(restTemplate, toughJetBaseUrl);
    }

    @Bean
    public CrazyAirService crazyAirService(){
        return new CrazyAirServiceImpl();
    }


    @Bean
    public ToughJetService toughJetService(){
        return new ToughJetServiceImpl();
    }

}
