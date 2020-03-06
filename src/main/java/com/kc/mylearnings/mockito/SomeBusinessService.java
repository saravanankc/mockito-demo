package com.kc.mylearnings.mockito;

public class SomeBusinessService {
    private DataService dataService;

    public SomeBusinessService(DataService dataService) {
        this.dataService = dataService;
    }

    int findGreatestFromAllData(){
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for (int value: data) {
            if(value > greatest){
                greatest = value;
            }
        }
        return greatest;
    }
}
