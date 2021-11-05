package com.bitwise;

public class FindMaximumMinimumOfTwoIntegersWithoutCondition {

	public static int max(int a , int b) {

		return a - ((a-b)&((a-b)>>31));
	}


	public static int min(int a , int b) {

		return b + ((a-b)&((a-b)>>31));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(max(4,5));

		System.out.println(max(5,4));

		System.out.println(max(4,-5));
		

		System.out.println(max(0,-5));

		System.out.println(max(-6,-5));
		
		System.out.println("-----------------------------");
		System.out.println(min(4,5));

		System.out.println(min(5,4));

		System.out.println(min(4,-5));
		

		System.out.println(min(0,-5));

		System.out.println(min(-6,-5));


	}

}
