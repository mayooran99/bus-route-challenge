package com.busroute.challenge.models;

import org.springframework.stereotype.Component;

/**
 * Class representing the model of the response object of the controller
 */
@Component
public class BusRouteResponse {

    private int depStationId;
    private int arrStationId;
    private boolean directBusRoute;

    /**
     * Method to get the departure station id
     *
     * @return station id of the departure
     */
    public int getDepStationId() {
        return depStationId;
    }

    /**
     * Method to set the departure station id
     *
     * @param depStationId station id of the departure
     */
    public void setDepStationId(int depStationId) {
        this.depStationId = depStationId;
    }

    /**
     * Method to get the arrival station id
     *
     * @return station id of the arrival
     */
    public int getArrStationId() {
        return arrStationId;
    }

    /**
     * Method to set the arrival station id
     *
     * @param arrStationId station id of the arrival
     */
    public void setArrStationId(int arrStationId) {
        this.arrStationId = arrStationId;
    }

    /**
     * Method to get the connect status between stations
     *
     * @return true if connection exists between the given stations
     */
    public boolean isDirectBusRoute() {
        return directBusRoute;
    }

    /**
     * Method to set the connect status between stations
     *
     * @param directBusRoute value indicating whether a connection exists between the stations
     */
    public void setDirectBusRoute(boolean directBusRoute) {
        this.directBusRoute = directBusRoute;
    }
}
