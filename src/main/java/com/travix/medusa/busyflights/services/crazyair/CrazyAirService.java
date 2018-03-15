package com.travix.medusa.busyflights.services.crazyair;

import com.travix.medusa.busyflights.common.exceptions.CrazyAirException;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by danilopereira on 15/03/18.
 */
@Service
public interface CrazyAirService {
    CompletableFuture<List<CrazyAirResponse>> getFlights(CrazyAirRequest crazyAirRequest) throws CrazyAirException;
}
