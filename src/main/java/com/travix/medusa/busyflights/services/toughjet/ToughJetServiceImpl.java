package com.travix.medusa.busyflights.services.toughjet;

import com.travix.medusa.busyflights.clients.toughjet.ToughJetClient;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
public class ToughJetServiceImpl implements ToughJetService {
    @Autowired
    private ToughJetClient toughJetClient;

    @Override
    public List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequest) {
        return null;
    }
}
