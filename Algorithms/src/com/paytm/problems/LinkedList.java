package com.paytm.problems;

public class LinkedList {

	private Node head ;
	
	public LinkedList(Node head) {
		 this.head = head;
	}

	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void addNode(Node node) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
}
