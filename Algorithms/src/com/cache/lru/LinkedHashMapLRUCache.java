package com.cache.lru;

import java.util.LinkedHashMap;

public class LinkedHashMapLRUCache {


	private LinkedHashMap<Integer, DataNode> keyVsData;
	private final int CACHE_SIZE ;


	public LinkedHashMapLRUCache(int size) {

		keyVsData = new LinkedHashMap<>(size , 1);
		CACHE_SIZE = size;
	}


	/*
	  If not present , then add at end (most recent used)
	  Else return what's present by removing and adding again(to take care of access order)
	 */
	public void refer(DataNode dataNode) {

		if(keyVsData.size() == CACHE_SIZE) {
			// remove least recently used
			DataNode nodeRemoved = keyVsData.get(keyVsData.keySet().iterator().next());
			if(nodeRemoved != null) {
				System.out.println("Node removed :" + nodeRemoved.toString());
				keyVsData.remove(nodeRemoved.getKey());
			}
		}

		keyVsData.remove(dataNode.getKey());

		keyVsData.put(dataNode.getKey(), dataNode);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMapLRUCache cache = new LinkedHashMapLRUCache(4);

		cache.refer(new DataNode(1, "Aditya", "Pune"));
		cache.refer(new DataNode(2, "Ashahar", "Pune"));
		cache.refer(new DataNode(3, "Ami", "Pune"));
		cache.refer(new DataNode(1, "Aditya", "Pune"));
		cache.refer(new DataNode(4, "Amit", "Pune"));
		cache.refer(new DataNode(5, "Avinash", "Pune"));
		cache.refer(new DataNode(6, "Atul", "Pune"));


	}

}
