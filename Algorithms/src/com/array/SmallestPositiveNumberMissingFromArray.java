package com.array;

public class SmallestPositiveNumberMissingFromArray {

	//technique similar to quick sort partitioning
	private static int findPivot(int [] array) {
		int pivot = 0; //assume first position to be pivot

		for(int i = 0 ; i < array.length ; i++) {

			if(array[i] > 0) {
				int temp = array[i];
				array[i] = array[pivot];
				array[pivot] = temp;
				pivot++;
			}

		}

		return pivot ; // returns index of first non-positive number
	}

	public static int findSmallestMissingPositiveNumber(int [] array) {

		int size = array.length;

		int pivot = findPivot(array);

		//go through all positive numbers
		for(int i = 0; i < pivot ; i++) {

			int val = Math.abs(array[i]);

			if(val-1 < size && array[ val - 1] > 0)
				array[val - 1] = -1*array[val - 1] ;

		}

		for(int i = 0 ; i < size ; i++ )
			if(array[i] > 0)
				return i+1;

		return size+1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {1 , 4 ,  -1 , 2 ,  -2 , 5} ;
		System.out.println(findSmallestMissingPositiveNumber(array));

		int [] array1 = {1 , 4 ,  3 , 2  } ;
		System.out.println(findSmallestMissingPositiveNumber(array1));

		int [] array2 = {0 , 4 ,  -1 , 2 ,  -2 , 5} ;
		System.out.println(findSmallestMissingPositiveNumber(array2));

	}


}
