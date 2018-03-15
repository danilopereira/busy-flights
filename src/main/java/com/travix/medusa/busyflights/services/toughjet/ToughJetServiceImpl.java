package com.travix.medusa.busyflights.services.toughjet;

import com.travix.medusa.busyflights.clients.toughjet.ToughJetClient;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by danilopereira on 15/03/18.
 */
public class ToughJetServiceImpl implements ToughJetService {
    private static final Logger log = LoggerFactory.getLogger(ToughJetServiceImpl.class);

    @Autowired
    private ToughJetClient toughJetClient;

    @Override
    @Async
    public CompletableFuture<List<ToughJetResponse>> getFlights(ToughJetRequest toughJetRequest) throws Exception {
        log.info("Thread Name : " +Thread.currentThread().getName());
        List<ToughJetResponse> toughJetResponses = new ArrayList<>();
        ResponseEntity<ToughJetResponse[]> flights = toughJetClient.getFlights(toughJetRequest);

        if(HttpStatus.OK.equals(flights.getStatusCode())){
            for(int i = 0; i < flights.getBody().length; i++){
                toughJetResponses.add(flights.getBody()[i]);
            }
        }else{
            throw new Exception(flights.getStatusCodeValue() +  " : " + flights.getBody().toString());
        }
        return CompletableFuture.completedFuture(toughJetResponses);
    }
}
