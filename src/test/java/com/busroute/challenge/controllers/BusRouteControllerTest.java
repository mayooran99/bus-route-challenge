package com.busroute.challenge.controllers;


import com.busroute.challenge.models.BusRouteResponse;
import com.busroute.challenge.providers.BusRouteDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Macilamanym on 2/10/2017.
 */
public class BusRouteControllerTest {

    BusRouteController busRouteController;
    BusRouteDataProvider busRouteDataProviderMock;

    @Before
    public void setup() {
        busRouteController = new BusRouteController();
        busRouteDataProviderMock = mock(BusRouteDataProvider.class);
        Whitebox.setInternalState(busRouteController, "busRouteDataProvider", busRouteDataProviderMock);
        Whitebox.setInternalState(busRouteController, "busRouteResponse", new BusRouteResponse());
    }

    @Test
    public void should_return_true_when_connection_exists_between_given_dep_sid_and_arr_sid() {
        String expectedResponse = "{  \"depStationId\" : 2,  \"arrStationId\" : 6,  \"directBusRoute\" : true}";
        when(busRouteDataProviderMock.queryDirectConnectionofStations(2, 6)).thenReturn(true);
        String actualResponse = busRouteController.getDirectConnectionInfo(2, 6).replaceAll("(\\r|\\n|\\t)", "");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void should_return_false_when_connection_does_not_exist_between_dep_sid_and_arr_sid() {
        String expectedResponse = "{  \"depStationId\" : 2,  \"arrStationId\" : 9,  \"directBusRoute\" : false}";
        when(busRouteDataProviderMock.queryDirectConnectionofStations(2, 9)).thenReturn(false);
        String actualResponse = busRouteController.getDirectConnectionInfo(2, 9).replaceAll("(\\r|\\n|\\t)", "");
        assertEquals(expectedResponse, actualResponse);
    }
}