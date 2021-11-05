package com.array.dp;

public class LongestCommonSubSequence {

	 
	private static int findLengthOfLCS(char[] X, char[] Y, int m, int n) {
		
		if(m < 0 || n < 0) {
			return 0;
	    }else if(X[m] == Y[n]) {
			return 1 + findLengthOfLCS(X, Y, m-1, n-1);
		}else {
			return Integer.max(findLengthOfLCS(X, Y, m-1, n), findLengthOfLCS(X, Y, m, n-1));
		}
		
	}

	public static void main(String[] args) {
		//String a = "ABCDGH" , b = "AEDFHR" ;
		
		//String a = "ABD" , b = "AED" ;
		
		String a = "AGGTAB" , b = "GXTXAYB" ;
		System.out.println(findLengthOfLCS(a.toCharArray(), b.toCharArray(), a.length()-1, b.length()-1));

	}

}
