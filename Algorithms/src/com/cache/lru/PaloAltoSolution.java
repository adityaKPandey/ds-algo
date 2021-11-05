package com.cache.lru;

import java.util.HashSet;
import java.util.Set;

public class PaloAltoSolution {

    public int solution(String[] A) {
        // write your code in Java SE 8

         //for()
    	 
         return solution(A, -1 ,"");
         //return 0;

    }

    private int solution(String [] A , int start , 
             String currentOp){
         int maxLen = 0; 
         for(int i = start ; i < A.length - 1 ; i++){
                
              for(int j = i+1 ; j < A.length ; j++){
                  
                  if(checkUnique(currentOp , A[j])){
                     int len = solution(A , i+1 , currentOp+A[j]);
                     if(maxLen < len )
                       maxLen = len;
                  }  
              }
         }       
          if(currentOp.length() > maxLen)
        	  maxLen = currentOp.length();
          
          return maxLen;
    }

   //true if can be combined
    private boolean checkUnique(String a , String b){
        
        if(b != null && a != null && a.equals(b))
         return false;

        Set<Integer>chars = new HashSet<>();
        if(!a.equals("")){
          for(char c: a.toCharArray()){
            Integer num = (int)c;
            chars.add(num);
          }
        }

        if(chars.size() != a.length())
          return false;

          if(b != null && !b.equals("")){
            //Set<Integer>chars2 = new HashSet<>();
             for(char c: b.toCharArray()){
                Integer num = (int)c;
                if(chars.contains(num))
                  return false;

                 chars.add(num);
             }

             if(chars.size() != (a.length() + b.length()))
                return false;
         }

        return true;

    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String [] A = {"co" , "dil" , "ity"} ;
		//String [] A = { "abc" , "yyy" , "def", "csv"};
		//String [] A = {"potato", "kayak", "banana", "racecar" };
		String [] A =  { "eva", "jqw", "tyn", "jan" } ;
		PaloAltoSolution solution = new PaloAltoSolution();
		System.out.println(solution.solution(A));
	}

}
