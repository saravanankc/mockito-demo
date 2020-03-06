package com.kc.mylearnings.mockito;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SomeBusinessServiceWithMockitoTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessService someBusinessService;

    //Mockito helps to mock outputs for stub classes/interface. In this case input tested multiple values
    @Test
    public void findGreatestFromAllData_WithMultipleInputs() {
        // DataService dataService = Mockito.mock(DataService.class); //This is created automatically by using @Mocks annotation

        //Mockito helps to mock outputs for stub classes/interface
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{12,23,23,45,76,67,99,23,100});
        // SomeBusinessService someBusinessService = new SomeBusinessService(dataService); // This is created automatically by using @InjectMocks annotation
        assertEquals(100, someBusinessService.findGreatestFromAllData());
    }

    //Mockito helps to mock outputs for stub classes/interface. IN this case input tested with 1 value
    @Test
    public void findGreatestFromAllData_WithSingleInputs() {
        DataService dataService = Mockito.mock(DataService.class);
        when(dataService.retrieveAllData()).thenReturn(new int[]{100});
        SomeBusinessService someBusinessService = new SomeBusinessService(dataService);
        assertEquals(100, someBusinessService.findGreatestFromAllData());
    }
}