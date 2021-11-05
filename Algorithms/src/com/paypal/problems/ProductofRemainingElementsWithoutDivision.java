package com.paypal.problems;

public class ProductofRemainingElementsWithoutDivision {

	
	private static long [] productWithoutDivision(int [] input) {
		
		int size = input.length;
		long [] product = new long[size];
		
		if(size == 1) {
			
			product[0] = 0;
			return product;
			
		}
		
		long [] forwardProduct = new long[size];
		long [] backwardProduct = new long[size];

		long f = 1 ;
		long b = 1;
		
		for(int i = 0 ; i < input.length ; i++) {
			
			
			f = f*input[i];
			b = b*input[size-i-1] ;
			
			forwardProduct[i] = f;
			backwardProduct[size-i-1] = b;
			
		}
		
		for(int i = 0 ; i < input.length ; i++) {
			
			if( i == 0) {
				product[0] = backwardProduct[1];
			}else if(i == input.length - 1) {
				product[i] =  forwardProduct[i-1];
			}else
			   product[i] = forwardProduct[i-1] * backwardProduct[i+1];
		}
		
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {3,4,5,6} ;		
		printResult(productWithoutDivision(array));
		
		System.out.println("###################################");
		
		int [] array1 = { 1 , 2 ,3 ,4 ,5} ;
		printResult(productWithoutDivision(array1));
		

	}

	private static void printResult(long[] product) {
		for(long p : product)
		  System.out.println(p + " ");
	}

}
