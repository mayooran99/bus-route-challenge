package com.busroute.challenge.controllers;

import com.busroute.challenge.models.BusRouteResponse;
import com.busroute.challenge.providers.BusRouteDataProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to serve bus route information
 */

@RestController
public class BusRouteController {

    @Autowired
    @Qualifier("BusRouteDataProviderImpl")
    private BusRouteDataProvider busRouteDataProvider;
    @Autowired
    private BusRouteResponse busRouteResponse;
    private static final Logger LOGGER = LoggerFactory.getLogger(BusRouteController.class);


    /**
     * Method to find if a connection exists between two given stations
     *
     * @param depStationId station id for the departure station
     * @param arrStationId station id for the arrival station
     * @return true if a connection exists between the given stations
     */
    @RequestMapping(value = "/api/direct", method = RequestMethod.GET)
    public String getDirectConnectionInfo(@RequestParam("dep_sid") int depStationId, @RequestParam("arr_sid") int arrStationId) {
        boolean directBusRouteExists = false;
        String json;
        directBusRouteExists = busRouteDataProvider.queryDirectConnectionofStations(depStationId, arrStationId);
        busRouteResponse.setArrStationId(arrStationId);
        busRouteResponse.setDepStationId(depStationId);
        busRouteResponse.setDirectBusRoute(directBusRouteExists);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            json = ow.writeValueAsString(busRouteResponse);
        } catch (JsonProcessingException ex) {
            json = "";
            LOGGER.error("Error occurred while mapping the response object to JSON", ex);
        }
        return json;
    }
}