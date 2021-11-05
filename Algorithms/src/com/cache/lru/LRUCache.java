package com.cache.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	 private Deque<DataNode>accessOrder;
	 private Map<Integer, DataNode> keyVsData;
	 private final int CACHE_SIZE ;

	 
	 public LRUCache(int size) {
		 accessOrder = new LinkedList<>();
		 keyVsData = new HashMap<>(size , 1);
		 CACHE_SIZE = size;
	 }
	 
	 /*
	  IF not present , then add.
	  Else return what's present
	 */
	 
	 public void refer(DataNode dataNode) {
		 
		 if(accessOrder.size() == CACHE_SIZE) {
			 // remove least recently used
			 DataNode nodeRemoved = accessOrder.removeLast();
			 System.out.println("Node removed :" + nodeRemoved.toString());
			 keyVsData.remove(nodeRemoved.getKey());
		 }else {
			 accessOrder.remove(dataNode); //O(n) operation
		 }
		 
		 keyVsData.put(dataNode.getKey(), dataNode);
		 accessOrder.push(dataNode);
		 
		 
	 }
	 
 	
	public static void main(String[] args) {
		 
		LRUCache cache = new LRUCache(4);
		
		cache.refer(new DataNode(1, "Aditya", "Pune"));
		cache.refer(new DataNode(2, "Ashahar", "Pune"));
		cache.refer(new DataNode(3, "Ami", "Pune"));
		cache.refer(new DataNode(1, "Aditya", "Pune"));
		cache.refer(new DataNode(4, "Amit", "Pune"));
		cache.refer(new DataNode(5, "Avinash", "Pune"));
		cache.refer(new DataNode(6, "Atul", "Pune"));

	}
	
	

}
