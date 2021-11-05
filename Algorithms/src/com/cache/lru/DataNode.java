package com.cache.lru;

public class DataNode {

	private Integer key;
	private String value1;
	private String value2;
	
	
	public DataNode(Integer key, String value1, String value2) {
		super();
		this.key = key;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}


	@Override
	public String toString() {
		return "DataNode [key=" + key + ", value1=" + value1 + ", value2=" + value2 + "]";
	}
	
	
	
	
}
