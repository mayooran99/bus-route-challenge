package com.busroute.challenge.models;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.mockito.internal.util.reflection.Whitebox;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Macilamanym on 2/10/2017.
 */
public class BusRouteResponseTest {
    private BusRouteResponse busRouteResponse;

    @Before
    public void setup() {
        busRouteResponse = new BusRouteResponse();
        Whitebox.setInternalState(busRouteResponse, "depStationId", 1);
        Whitebox.setInternalState(busRouteResponse, "arrStationId", 2);
        Whitebox.setInternalState(busRouteResponse, "directBusRoute", true);
    }

    @Test
    public void should_return_depStationId_when_getDepStationId_is_called() {
        assertEquals(1, busRouteResponse.getDepStationId());
    }

    @Test
    public void should_return_arrStationId_when_getArrStationId_is_called() {
        assertEquals(2, busRouteResponse.getArrStationId());
    }

    @Test
    public void should_return_directBusRoute_when_isDirectBusRoute_is_called() {
        assertEquals(true, busRouteResponse.isDirectBusRoute());
    }

    @Test
    public void should_set_depStationId_when_setDepStationId_is_called() {
        busRouteResponse.setDepStationId(10);
        int actualDepStationId = (int) Whitebox.getInternalState(busRouteResponse,"depStationId");
        assertEquals(10,actualDepStationId);
    }

    @Test
    public void should_set_arrStationId_when_setArrStationId_is_called() {
        busRouteResponse.setArrStationId(10);
        int actualArrStationId = (int) Whitebox.getInternalState(busRouteResponse,"arrStationId");
        assertEquals(10,actualArrStationId);
    }

    @Test
    public void should_set_directBusRoute_when_setDirectBusRoute_is_called() {
        busRouteResponse.setDirectBusRoute(false);
        boolean actualDirectBusRoute = (boolean) Whitebox.getInternalState(busRouteResponse,"directBusRoute");
        assertEquals(false,actualDirectBusRoute);
    }
}