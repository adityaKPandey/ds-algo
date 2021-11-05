package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class MatrixToAdjacencyList {

	
	private int noOfVertices ;
	
	private List<List<Integer>>adjacencyList;
	
	
	
	public MatrixToAdjacencyList(int noOfVertices, List<List<Integer>> adjacencyList) {
		super();
		this.noOfVertices = noOfVertices;
		this.adjacencyList = adjacencyList;
	}

	private static List<List<Integer>> createAdjacencyList(int [][] matrixGraph , int numNodes){
		
		List<List<Integer>>adjacencyList = new ArrayList<>();
		// 0 based index system
		
		for(int i = 0 ; i < numNodes ; i++) {
			
			adjacencyList.add(i, new ArrayList<>());
			
			for(int j = 0 ; j < numNodes ; j++) {
				if(matrixGraph[i][j] > 0) {
				 adjacencyList.get(i).add(j);
				 
				}
			}
			
		}
		
		return adjacencyList;
		
	}
	
	public static void main(String[] args) {
		
		int numOfNodes = 5;
		int [][] matrix = new int [] [] {
			{0,1,0,0,1},
			{1,0,1,1,1},
			{0,1,0,1,0},
			{0,1,1,0,1},
			{1,1,0,1,0}
		};
		
		MatrixToAdjacencyList adjacencyList = new MatrixToAdjacencyList(numOfNodes , 
				createAdjacencyList(matrix, numOfNodes));
		
		for(int i = 0 ; i < adjacencyList.noOfVertices ; i++) {
			System.out.println("node : " + i + " , AL:" +adjacencyList.adjacencyList.get(i));
		}
		
		
		

	}

}
