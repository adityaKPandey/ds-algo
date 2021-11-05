package com.sorting;

public class MergeSort {

	private void mergeSort(int [] array , int l , int r) {
		
		if(r > l) {
			
			int m = (l+r)/2 ;
			
			mergeSort(array , l , m) ;
			mergeSort(array, m+1,  r);
			merge(array , l , m ,r) ;
			
		}
		
	}
	
	private void merge(int [] array , int l , int m , int r) {
		// array[l....m] and array[m+1 ..... r]
		
		int i = l , j = m+1;
		int c = 0;
		int [] temp = new int [r-l+1] ;
		
		while(i <=m && j <= r && i<j) {
			
		  if(array[j] < array[i]) {
			 
			  temp[c++] = array[j] ;
			  
			  j++;
		  }else {
			  temp[c++] = array[i] ;
			  
			  i++;
		  }
		  
		}
		
		while( i <= m) {
			temp[c++] = array[i++] ;
		}
		
		while( j <= r) {
			temp[c++] = array[j++] ;
		}
		
		int k = l ;
		for(i = 0 ; i < temp.length ; i++) {
		   array[k++]  =	temp[i] ;
		}
		
	}
	

	public static void main(String[] args) {
		 
        MergeSort mergeSort = new MergeSort() ;
        int [] array = {99} ;
        mergeSort.mergeSort(array, 0, array.length - 1);
		
        for(int a : array) {
        	System.out.println(a);
        }
        
	}

}
