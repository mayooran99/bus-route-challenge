package com.busroute.challenge.providers;

/**
 * Interface that provides the bus route information
 */
@FunctionalInterface
public interface BusRouteDataProvider {
    /**
     * Method to be implemented to provide the connection existence information between given stations
     *
     * @param depStationId station id representing the departure station
     * @param arrStationId station id representing the arrival station
     * @return true if connection exists between the given stations
     */
    boolean queryDirectConnectionofStations(int depStationId, int arrStationId);
}
