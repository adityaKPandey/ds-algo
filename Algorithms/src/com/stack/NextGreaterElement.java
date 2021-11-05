package com.stack;

import java.util.Stack;

public class NextGreaterElement {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NextGreaterElement nge = new NextGreaterElement();
		
		int [] array = {0,9,6,1,7,4,3,2} ;
		nge.printNextGreaterElement(array);
		
		System.out.println("#################");
		int [] array1 = {2,1,4,3,5,6,0,9,8} ;
		nge.printNextGreaterElement(array1);
		
		System.out.println("#################");
		int [] array2 = {9,8,9,7,6,5,4,3,2,1} ;
		nge.printNextGreaterElement(array2);
	}
	
	public void printNextGreaterElement(int [] array) {
		Stack<Integer>stack = new Stack<>();
		
		for(int i = 0 ; i < array.length ; i++) {
		   
			int next = array[i];
		   
		    while(!stack.isEmpty() && stack.peek() < next) {
		    	System.out.println(stack.pop() + " ----> " + next);
		    }
		    stack.push(next);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " ----> " + -1);
		}
		
		
	}

}
