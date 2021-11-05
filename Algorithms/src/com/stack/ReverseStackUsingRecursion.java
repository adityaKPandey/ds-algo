package com.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {


	private static void reverse(Stack<Integer>stack) {
		if(!stack.isEmpty()) {
			int num = stack.pop();
			System.out.println(num);
			reverse(stack);

		}

	}

	private static void reverseStack(Stack<Integer>stack) {
		if(!stack.isEmpty()) {
			int num = stack.pop();
			reverseStack(stack);
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		//reverse(stack);

		reverseStack(stack);
	}

}
