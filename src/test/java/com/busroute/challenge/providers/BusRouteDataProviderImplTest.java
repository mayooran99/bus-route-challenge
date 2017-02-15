package com.busroute.challenge.providers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by Macilamanym on 2/11/2017.
 */
public class BusRouteDataProviderImplTest {

    private BusRouteDataProviderImpl busRouteDataProvider;
    private Map<Integer, Set<Integer>> busRouteEntriesMap;

    @Before
    public void setup() {
        busRouteDataProvider = new BusRouteDataProviderImpl();
        busRouteEntriesMap = new HashMap<>();
        Set<Integer> routesForTheStationFour = new HashSet<>();
        routesForTheStationFour.add(2);
        Set<Integer> routesForTheStationSix= new HashSet<>();
        routesForTheStationSix.add(2);
        busRouteEntriesMap.put(4, routesForTheStationFour);
        busRouteEntriesMap.put(6,routesForTheStationSix);
        Whitebox.setInternalState(busRouteDataProvider,"busRouteEntriesMap",busRouteEntriesMap);
    }

    @Test
    public void should_return_true_when_depStationId_and_arrStationId_exist_in_the_route_data_file() {
        assertTrue(busRouteDataProvider.queryDirectConnectionofStations(4, 6));
    }

    @Test
    public void should_return_false_when_depStationId_and_arrStationId_does_not_exist_in_the_route_data_file() {
        assertTrue(!busRouteDataProvider.queryDirectConnectionofStations(3, 5));
    }
}