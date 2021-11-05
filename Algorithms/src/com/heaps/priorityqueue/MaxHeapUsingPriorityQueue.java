package com.heaps.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeapUsingPriorityQueue<T> {

	private Queue<T> queue;
	private int maxSize;
	
	public MaxHeapUsingPriorityQueue(int size , Comparator<T> comparator) {
		this.maxSize = size;
		queue = new PriorityQueue<>(maxSize , comparator);
	}
	
	
	public boolean insert(T element) {
		
		if(queue.size() < maxSize) 
			return queue.offer(element);
		else {
			
			T elementRemoved = queue.poll();
			System.out.println("CApacity overflow..removing " + elementRemoved + " to create space");
			return queue.offer(element);
		}
		 
	}
	
	public T remove() {
		return queue.peek();
	}
	

	
	


}
