package com.heaps.priorityqueue;

import java.util.Comparator;

public class KthMinElement<T> {

	public  T findKthMinimum( T [] array , int k) {
		MaxHeapUsingPriorityQueue<T> integerMaxHeap = new MaxHeapUsingPriorityQueue<T>(k, new DescendingOrder());
		
		// use lambda for comparator
		// MaxHeapUsingPriorityQueue<Integer> integerMaxHeap1 = new MaxHeapUsingPriorityQueue<Integer>(k, (a,b) -> a.compareTo(b) )  ;
	
		for(T num:array) {
			integerMaxHeap.insert((T) num);
		}
		
		return  integerMaxHeap.remove();
		
	}
	
	public static void main(String[] args) {
		 
		Integer [] array = {4,5,23,19,57,90,111,256,21};
		
		KthMinElement<Integer> finder = new KthMinElement<>();
		
		System.out.println(finder.findKthMinimum(array, 6));

	}


	 
}

class DescendingOrder<T> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		
		if(o1 instanceof Integer) {
			
			Integer a = (Integer) o1;
			Integer b = (Integer) o2;
			
			return b.compareTo(a);
			
		}else if(o1 instanceof String) {
			
			String a = (String) o1;
			String b = (String) o2;
			
			return b.compareTo(a);
			
		}
		return 0;
	}
	
}