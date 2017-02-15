package com.busroute.challenge.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class that provides bus station connection information with emphasis placed on time complexity.
 */
@Component(value = "BusRouteDataProviderImpl")
public class BusRouteDataProviderImpl implements BusRouteDataProvider {

    @Autowired
    private Map<Integer, Set<Integer>> busRouteEntriesMap;

    /**
     * Method to provide the connection existence information between given stations with emphasis on time constraints
     *
     * @param depStationId station id representing the departure station
     * @param arrStationId station id representing the arrival station
     * @return true if connection exists between the given stations
     */
    @Override
    public boolean queryDirectConnectionofStations(int depStationId, int arrStationId) {
        Map<Integer, Set<Integer>> busStationAndRoutes = this.busRouteEntriesMap;
        Set<Integer> routesOfTheDepStation = busStationAndRoutes.get(depStationId);
        Set<Integer> routesOfTheArrStation = busStationAndRoutes.get(arrStationId);
        if (routesOfTheArrStation != null && routesOfTheDepStation != null) {
            Set<Integer> commonRoutes = routesOfTheDepStation.stream()
                    .filter(s -> routesOfTheArrStation.contains(s))
                    .collect(Collectors.toSet());
            return !commonRoutes.isEmpty();
        }
        return false;
    }
}
