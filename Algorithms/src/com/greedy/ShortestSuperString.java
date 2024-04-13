package com.greedy;

public class ShortestSuperString {

	public ShortestSuperString() {

	}

	// Function to calculate maximum
	// overlap in two given strings - returns maximum overlapping string b/w str1 and str2
	static int findOverlappingPair(String str1,
			String str2 , StringBuilder maxOverlapStr ) {



		int max = 0;
		int len1 = str1.length();
		int len2 = str2.length();

		// str1 str2

		int match = 0;
		for(int i = 1 ; i < Math.min(len1, len2) ; i++) {

			if(str1.substring(str1.length() -  i ) .equals(
					str2.substring(0, i)
					) ) {

				match = i;
				if(match > max) {
					
					max = match;
					maxOverlapStr.setLength(0);
					maxOverlapStr.append( str2.substring(0,i) );
				}

			}

		}

		//str2 str1
		for(int i = 1 ; i < Math.min(len1, len2) ; i++) {

			if(str2.substring(str2.length() -  i ) .equals(
					str1.substring(0, i)
					) ) {

				match = i;
				if(match > max) {
					
					max = match;
					maxOverlapStr.setLength(0);
					maxOverlapStr.append( str1.substring(0,i) );

				}
			}

		}

		return max;

	}


	public static void main(String[] args) {


	}

}
