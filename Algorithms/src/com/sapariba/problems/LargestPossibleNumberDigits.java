package com.sapariba.problems;

import java.util.HashMap;
import java.util.Map;

public class LargestPossibleNumberDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findLargestPossibleNumber(1023l));
		System.out.println(findLargestPossibleNumber(981231l));
	}

	private static Long findLargestPossibleNumber(Long number) {
		Long largestNumber = 0l ;
		Map<Integer , Integer>digitToCount = new HashMap<>();

		long temp = number;
		int multiple = 1;

		while(temp > 0) {

			int rem  = (int) temp%10;
			temp = temp/10;

			int count = 0;
			if(digitToCount.containsKey(rem))
				count = digitToCount.get(rem);

			digitToCount.put(rem, ++count) ;
			multiple *= 10;

		}

		if(multiple > 1)
			multiple /= 10;
		
		for(int i = 9 ; i >= 0 ; i--) {
			if(digitToCount.containsKey(i)) {

				int count = digitToCount.get(i);
				while(count > 0) {
					largestNumber +=  i*multiple;
					multiple /= 10;
					count--;
					if(count == 0) {
						digitToCount.remove(i);
					}
				}

			}			
		}

		return largestNumber;
	}

}
