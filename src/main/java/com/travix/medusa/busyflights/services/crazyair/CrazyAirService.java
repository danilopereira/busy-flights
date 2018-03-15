package com.travix.medusa.busyflights.services.crazyair;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danilopereira on 15/03/18.
 */
@Service
public interface CrazyAirService {
    List<CrazyAirResponse> getFights(CrazyAirRequest crazyAirRequest);
}
