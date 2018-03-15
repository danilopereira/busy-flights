package com.travix.medusa.busyflights.services.toughjet;

import com.travix.medusa.busyflights.common.exceptions.ToughJetException;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by danilopereira on 15/03/18.
 */
@Service
public interface ToughJetService {
    CompletableFuture<List<ToughJetResponse>> getFlights(ToughJetRequest toughJetRequest) throws ToughJetException;
}
