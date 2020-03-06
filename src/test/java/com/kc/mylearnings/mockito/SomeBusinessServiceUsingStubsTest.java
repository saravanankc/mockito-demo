package com.kc.mylearnings.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessServiceUsingStubsTest {

    @Test
    void findGreatestFromAllData() {
        SomeBusinessService someBusinessService = new SomeBusinessService(new DataServiceStub());
        int result = someBusinessService.findGreatestFromAllData();
        assertEquals(99,result);
    }

    //NOT RECOMMENDED: Disadvantages for using a hardcoded stub - need to duplicate stub methods for different scenario/input data unit testing.
    // RECOMMENDED USE: Mockito
    class DataServiceStub implements DataService{
        @Override
        public int[] retrieveAllData() {
            return new int[]{12,43,65,99,43,34};
        }
    }
}