package com.heaps.array;

public class RunningMedian {

 
	
	public static void main(String[] args) {
  
		 int [] array = {10,15,5,8,20,9,2,12};
		 
		 RunningMedian runningMedian = new RunningMedian();
		
		 try {
		  runningMedian.calculateRunningMedian(array);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public void calculateRunningMedian(int [] array) throws Exception{
		
		MaxHeap maxHeap = new MaxHeap(15);
		MinHeap minHeap = new MinHeap(15);
		
		minHeap.insert(array[0]);
		
		double median = array[0];
		System.out.println("Median 1 : "+median);
		
		for(int i = 1 ; i < array.length ; i++) {
		     
			int num = array[i];
		     
			if(num <= median) {
			    //insert in max heap
				if(maxHeap.getIndex() > minHeap.getIndex()) {
					int max = maxHeap.delete();
					minHeap.insert(max);
					
				}
				maxHeap.insert(num);
				
				
				
			}else {
				
				//insert in min heap
				if(minHeap.getIndex() > maxHeap.getIndex()) {
					int min = minHeap.delete();
					maxHeap.insert(min);
					
				}
				minHeap.insert(num);
				
				
			}
			median = getMedian(maxHeap, minHeap, i);
			
			System.out.println("Median "+(i+1)+" :"+median);
		
		}
		
	}

	private double getMedian(MaxHeap maxHeap, MinHeap minHeap, int i) {
		double median;
		if(i%2 == 0) {
			median = maxHeap.getRoot();
			if(minHeap.getIndex() > maxHeap.getIndex())
				median = minHeap.getRoot();
			
		}else {
			
			median = ((double)( maxHeap.getRoot() + minHeap.getRoot() ))/2;
		
		}
		return median;
	}


}
