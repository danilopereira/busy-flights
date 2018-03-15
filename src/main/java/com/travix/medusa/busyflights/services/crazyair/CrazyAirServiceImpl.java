package com.travix.medusa.busyflights.services.crazyair;

import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClient;
import com.travix.medusa.busyflights.common.ErrorCode;
import com.travix.medusa.busyflights.common.exceptions.CrazyAirException;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
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
public class CrazyAirServiceImpl implements CrazyAirService {

    @Autowired
    private CrazyAirClient crazyAirClient;

    private static final Logger log = LoggerFactory.getLogger(CrazyAirServiceImpl.class);

    @Override
    @Async
    public CompletableFuture<List<CrazyAirResponse>> getFlights(CrazyAirRequest crazyAirRequest) throws CrazyAirException {
        log.info("Thread Name : " +Thread.currentThread().getName());
        List<CrazyAirResponse> crazyAirResponse = new ArrayList<>();
        ResponseEntity<CrazyAirResponse[]> flights = null;
        try{
            flights = crazyAirClient.getFlights(crazyAirRequest);
        }catch(Exception e){
            throw new CrazyAirException(ErrorCode.GENERIC_SUPPLIER_ERROR.value(), ErrorCode.GENERIC_SUPPLIER_ERROR.message());
        }
        if(HttpStatus.OK.equals(flights.getStatusCode())){
            for(int i = 0; i< flights.getBody().length; i++){
                crazyAirResponse.add(flights.getBody()[i]);
            }
        }
        else{
            throw new CrazyAirException(ErrorCode.GENERIC_SUPPLIER_ERROR.value(), ErrorCode.GENERIC_SUPPLIER_ERROR.message());
        }

        return CompletableFuture.completedFuture(crazyAirResponse);
    }
}
