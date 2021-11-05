package com.array;

/*
   
   Find the maximum value of `j – i` such that `A[j] > A[i]` in an array
   https://www.techiedelight.com/find-maximum-value-index-array/
   
 */
public class MaxGreaterElementIndexDifference {

	
	public static int getMaxDiff(int [] A) {
		int maxDiff = 0;
		int size = A.length;
		
		int [] max = new int [size];
		max[size-1] = A[size-1];
		
		for(int i = size - 2 ; i >= 0  ; i--) {
		   
			max[i] = Math.max(A[i], max[i+1]);
		
		}
		
		for(int i = 0 , j = 0; i < size && j < size ;) {
			
			if(A[i] > max[j])
				i++;
			else {
				
				if(j - i > maxDiff) {
				    System.out.println("Max diff update for vals:"+A[i] + "," +A[j]);
					maxDiff = j - i ;
				}	
				
				j++;
				
			}
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		 
		int [] A = {9 , 10 , 2, 6, 7 , 12 , 8 , 1} ;
		System.out.println("Max index difference:"+getMaxDiff(A));
		
		int [] A1 = {9 , 2 , 6, 8, 12 , 10 , 1 , 3 , 4} ;
		System.out.println("Max index difference:"+getMaxDiff(A1));
		
		int b = 0;
		 
		

	}

}
