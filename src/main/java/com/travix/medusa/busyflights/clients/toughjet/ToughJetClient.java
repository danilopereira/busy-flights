package com.travix.medusa.busyflights.clients.toughjet;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.ResponseEntity;

/**
 * Created by danilopereira on 15/03/18.
 */
public interface ToughJetClient {
    ResponseEntity<ToughJetResponse> getFlights(ToughJetRequest toughJetRequest);
}
