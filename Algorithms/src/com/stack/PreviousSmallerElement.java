package com.stack;

import java.util.Stack;

public class PreviousSmallerElement {

	 
	public static void printPreviousSmallerElement(int [] array) throws RuntimeException{
	  
		//throw new RuntimeException("");
		Stack<Integer> stack = new Stack<>() ;
	    
		for(int i = array.length - 1; i >= 0 ; i--) {
			
			Integer num = array[i] ;
			
			if(stack.isEmpty() || num > stack.peek()) {
				stack.push(num);
			}else {
				
				while(!stack.isEmpty() && stack.peek() > num) {
					System.out.println(stack.pop() + " ---------> " +num);
				}
				stack.push(num);
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " -------> -1"  );
		}
			  
	}
	
	public static void main(String[] args) {
 		
		int [] array = { 1 , 2 , 4 , 5 ,6, 7 ,3} ;
		printPreviousSmallerElement(array);
		
		System.out.println("###########################");
		int [] array1 = { 5, 7, 4, 9, 8, 10 } ;
		printPreviousSmallerElement(array1);

	}

}
