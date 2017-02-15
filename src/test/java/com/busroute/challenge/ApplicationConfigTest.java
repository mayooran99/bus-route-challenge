package com.busroute.challenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Macilamanym on 2/11/2017.
 */

@RunWith(PowerMockRunner.class)
public class ApplicationConfigTest {
    BufferedReader readerMock;
    FileReader fileReaderMock;
    ApplicationConfig applicationConfig;

    @Before
    public void setup() {
        readerMock = PowerMockito.mock(BufferedReader.class);
        fileReaderMock = PowerMockito.mock(FileReader.class);
        applicationConfig = new ApplicationConfig();
    }

    @PrepareForTest({BufferedReader.class, ApplicationConfig.class, FileReader.class})
    //@Test
    public void should_return_set_with_correct_routes_and_stations_when_valid_file_is_given() throws Exception {
        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fileReaderMock);
        PowerMockito.whenNew(BufferedReader.class).withArguments(any(FileReader.class)).thenReturn(readerMock);
        when(readerMock.readLine()).thenReturn("1").thenReturn("2 4 6").thenReturn(null);
        Map<Integer, Set<Integer>> actualMap = applicationConfig.busRouteEntriesMap("someFile");

        Map<Integer, Set<Integer>> expectedMap = new HashMap<>();
        Set<Integer> expectedSet1 = new HashSet<>();
        expectedSet1.add(2);
        expectedMap.put(4, expectedSet1);
        Set<Integer> expectedSet2 = new HashSet<>();
        expectedSet2.add(2);
        expectedMap.put(6, expectedSet2);

        assertThat(actualMap, is(expectedMap));
    }

    @PrepareForTest({ApplicationConfig.class, FileReader.class})
    //@Test(expected = IOException.class)
    public void should_throw_IOException_when_unable_to_read_contents_from_the_given_file() throws Exception {
        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenThrow(IOException.class);
        applicationConfig.busRouteEntriesMap("someFile");
    }

    @PrepareForTest({BufferedReader.class, ApplicationConfig.class, FileReader.class})
    //@Test
    public void should_return_empty_map_when_contents_of_the_file_are_empty() throws Exception {
        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fileReaderMock);
        PowerMockito.whenNew(BufferedReader.class).withArguments(any(FileReader.class)).thenReturn(readerMock);
        when(readerMock.readLine()).thenReturn("0").thenReturn("").thenReturn(null);
        Map<Integer, Set<Integer>> actualMap = applicationConfig.busRouteEntriesMap("someFile");

        Map<Integer, Set<Integer>> emptyMap = new HashMap<>();

        assertThat(actualMap, is(emptyMap));
    }

    @PrepareForTest({BufferedReader.class, ApplicationConfig.class, FileReader.class})
    @Test
    public void should_return_map_with_correct_elements_when_multiple_rows_returned_from_route_file() throws Exception {
        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fileReaderMock);
        PowerMockito.whenNew(BufferedReader.class).withArguments(any(FileReader.class)).thenReturn(readerMock);
        when(readerMock.readLine()).thenReturn("2").thenReturn("2 4 6").thenReturn("3 5 7").thenReturn(null);
        Map<Integer, Set<Integer>> actualMap = applicationConfig.busRouteEntriesMap("someFile");

        Map<Integer, Set<Integer>> expectedMap = new HashMap<>();
        Set<Integer> expectedSet1 = new HashSet<>();
        expectedSet1.add(2);
        expectedMap.put(4, expectedSet1);
        Set<Integer> expectedSet2 = new HashSet<>();
        expectedSet2.add(2);
        Set<Integer> expectedSet3 = new HashSet<>();
        expectedSet3.add(3);
        expectedMap.put(5,expectedSet3);
        Set<Integer> expectedSet4 = new HashSet<>();
        expectedSet4.add(3);
        expectedMap.put(7,expectedSet4);
        expectedMap.put(6, expectedSet2);

        assertThat(actualMap, is(expectedMap));
    }
}