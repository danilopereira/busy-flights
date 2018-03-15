package com.travix.medusa.busyflights.services.crazyair;

import com.travix.medusa.busyflights.clients.crazyair.CrazyAirClient;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
public class CrazyAirServiceImpl implements CrazyAirService {

    @Autowired
    private CrazyAirClient crazyAirClient;

    @Override
    public List<CrazyAirResponse> getFights(CrazyAirRequest crazyAirRequest) {
        return null;
    }
}
