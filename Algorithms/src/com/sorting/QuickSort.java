package com.sorting;

public class QuickSort {

	 
	
	private void quickSort(int arr [] , int low , int high) {
		
		if(low < high) {
			
			int pivot = partition(arr,low,high) ;
			System.out.println("pivot index:"+pivot);
			quickSort(	arr , low, pivot-1);
		    quickSort(arr, pivot+1, high);
	
		}
	}
	
	private int partition(int [] arr , int low , int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j = low ; j < high ; j++) {
			
			if(arr[j] <= pivot ) {
                i++;
              //swap arr[i] and arr[j]
				int temp = arr[i] ;
				arr[i] = arr[j];
                arr[j] = temp;
			}
			
			
		}
		
		//swap pivot position element and element at new position
		arr[high] = arr[i+1];
		arr[i+1] = pivot;
		
		
		return i+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int [] array = { 10, 90 , 50 , 20 , 15 , 60 , 55 , 40 } ;
		
		
		int [] array = { 99 , 98 , 90 , 80 , 75 , 60 } ;
		
		QuickSort quickSort = new QuickSort();
		
		quickSort.quickSort(array, 0, array.length - 1);
		
		System.out.println("Sorted:");
		
		for(int i = 0 ; i < array.length ; i++) {
		  System.out.print(array[i] + " ");	
		}
		
	}

}
