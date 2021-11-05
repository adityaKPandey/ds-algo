package com.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MinPlatformToScheduleTrains {

	public MinPlatformToScheduleTrains() {
		// TODO Auto-generated constructor stub
	}
	
	 // Function to find the minimum number of platforms needed
    // to avoid delay in any train arrival
    public static int findMinimumPlatforms(double[] arrival, double[] departure)
    {
    	int count = 0;
    	
    	int maxCount = 0;
    	
    	Set<Double>timeLine = new TreeSet<>();
    	
    	Map<Double,Integer>arrivalTimes = new HashMap<>();
    	Map<Double,Integer>departureTimes = new HashMap<>();
    	
    	for(double time:arrival) {
    		timeLine.add(time);
    		
    		int trains = 0;
    		if(arrivalTimes.containsKey(time))
    			trains = arrivalTimes.get(time);
    		
    		arrivalTimes.put(time, trains+1);
    	}
    	
    	for(double time:departure) {
    		timeLine.add(time);
    		
    		int trains = 0;
    		if(departureTimes.containsKey(time))
    			trains = departureTimes.get(time);
    		
    		departureTimes.put(time, trains+1);
    	}
    	
    	
    	for(Double time:timeLine) {
    		
    		// depart train first - to handle case where trains arrive and depart at same time
    		if(departureTimes.containsKey(time))
    			count -= departureTimes.get(time);
    		
    		if(arrivalTimes.containsKey(time))
    			count += arrivalTimes.get(time);
    		
    		
    		if(count > maxCount) {
    			maxCount = count;
    			System.out.println("Max count updated to "+maxCount + " at time :"+time);
    		}		
    		
    		
    		
    		
    	}
    	
    	
    	return maxCount;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
        double[] departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };
 
        System.out.print("The minimum platforms needed is "
                    + findMinimumPlatforms(arrival, departure));
        
	}

}
