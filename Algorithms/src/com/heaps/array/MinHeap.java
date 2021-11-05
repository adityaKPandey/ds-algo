package com.heaps.array;

public class MinHeap {

	private int [] array ;
	private int index ;

	public MinHeap(int maxSize) {

		index = 0;
		array = new int [maxSize];

	}
	
	public int getIndex() {
		return index;
	}
	
	public int getRoot() {
		return array[0];
	}


	public void insert(int value) throws Exception {

		if(index < array.length) {
			array[index++] = value;
			minHeapify();
		}else {
			throw new Exception("Heap is full") ;
		}

	}

	//delete top-smallest element
	public int delete() {
		//swap first element with last
		int temp = array[0] ;
		array[0] = array[index] ;
		array[index] = temp;

		index--;

		int i = 0;

		while(i <= index) {
			int leftChildIndex = 2*i + 1;
			int rightChildIndex = 2*i + 2;

			if(leftChildIndex > index)
				break;
			
			int smallerIndex = leftChildIndex;
			

			if(rightChildIndex <= index && array[leftChildIndex] > array[rightChildIndex] )
				smallerIndex = rightChildIndex;

			temp = array[smallerIndex];
			array[smallerIndex] = array[i];
			array[i] = temp;
			i = smallerIndex;
		}
		return temp;
	}


	private void minHeapify() {

		int i = index-1;
		while(i > 0) {
			int parent = i/2;
			if(array[parent] > array[i]) {
				//swap them
				int temp = array[parent];
				array[parent] = array[i];
				array[i] = temp;


			}
			i = parent;
		}

	}

	public static void main(String[] args) {




	}

}
