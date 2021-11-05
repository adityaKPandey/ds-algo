package com.paytm.problems;

public class ReverseEveryKNodes {

    public static Node reverseEveryKNodes(LinkedList linkedList , int k) {
    	
    	Node temp = linkedList.getHead();
    	Node newHead = null;
    	boolean reverse = true;
    	int i = 0;
    	while(temp != null) {
    	    i++;
    		if(reverse) {
    		  
    		  Node [] result =	reverseKNodes(temp, k); //new start , new end
    		  temp = result[1].next;
    		  
    		  if(i == 1) {
    			  newHead = result[0];
    		  }
    		  
    		}else {
    			int j = 0;
    			while(j < k-1) {
    				temp = temp.next
    				j++;
    			}
    		}
    			
    		
    		reverse = !reverse;
    	}
    	
    	linkedList.setHead(newHead);
    	return linkedList.getHead();
    }
    
    private static Node[] reverseKNodes(Node start , int k) {
    	
    	Node temp1 = null , temp2 = start , temp3 = start.next;
    	int m  = k;
    	Node [] result = new Node [2] ;
    	
    	while(temp2 != null && m > 0) {
    	
    		temp2.next = temp1 ; 
    		temp1 = temp2;
    		temp2 = temp3 ;
    		if(temp3 != null && m>0)
    		 temp3 = temp3.next;
    		
    		m--;
    		
    	}
    	
    	start.next = temp3;
    	result[1] = start;
    	result[0] = temp2; 
    	return result;
    	
    }

	public static void main(String[] args) {
		
	   Node head = new Node(1);
	   LinkedList linkedList = new LinkedList(head);
	   linkedList.addNode(new Node(2));
	   linkedList.addNode(new Node(3));
	   linkedList.addNode(new Node(4));
	   linkedList.addNode(new Node(5));
	   
	   
	   
	}

}
