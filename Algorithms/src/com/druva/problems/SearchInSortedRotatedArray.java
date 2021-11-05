package com.druva.problems;

import java.util.Stack;

public class SearchInSortedRotatedArray {


	/*
	   original array: 10 12 24 33 39 42 50 61 78 90
	   rotated array:  33 39 42 50 61 78 90 10 12 24 
	 */

	private static int search(int [] array , int toSearch) {

		int index = binarySearch(array , 0 , array.length - 1 , toSearch , true);

		if(index != - 1) {
			if(array[index] == toSearch)
				return index;

			//System.out.println("Pivot:"+index);
			if(toSearch >= array[index] && array[array.length - 1] >= toSearch )
				return binarySearch(array, index+1, array.length - 1, toSearch , false);

			return binarySearch(array, 0, index - 1, toSearch , false) ;
		}

		return index;
	}

	private static int binarySearch(int [] array , int low , int high , int toSearch , boolean searchPivot) {

		if(low <= high) {

			int mid = (low + high)/2;
			if(array[mid] == toSearch) {
				return mid;
			}

			if(searchPivot) {
				if(mid < array.length - 1 && array[mid+1] < array[mid])
					return mid+1; // the smaller ele

				if(mid -1 > -1 && array[mid-1] > array[mid])
					return mid;  //the smaller ele
			}

			if(!searchPivot) {
				if(toSearch < array[mid])
					return binarySearch(array, low, mid - 1, toSearch, searchPivot);
				else
					return binarySearch(array, mid + 1, high, toSearch, searchPivot);
			}


			/*int result1 = binarySearch(array, low, mid - 1, toSearch , searchPivot);
			if(result1 == -1 )
				return binarySearch(array, mid+1, high, toSearch , searchPivot) ;
			else 
				return result1;*/

			if(array[low] >= array[mid-1] )
				return binarySearch(array, low, mid - 1, toSearch , searchPivot);
			else
				return binarySearch(array, mid+1, high, toSearch , searchPivot) ;

		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = { 33 , 39 , 42 ,  50 ,  61 ,  78 ,  90 ,  10 ,  12 , 22 , 23 ,  24 };

		System.out.println(search(array , 33));
		System.out.println(search(array , 24));//F
		System.out.println(search(array , 10));
		System.out.println(search(array , 90));
		System.out.println(search(array , 42));//F
		System.out.println(search(array , 12));
		System.out.println(search(array , 35));
		System.out.println(search(array , 8));
		System.out.println(search(array , 26));
		System.out.println(search(array , 78));
		System.out.println(search(array , 22));
		System.out.println(search(array , 23));



		 
	}

}
