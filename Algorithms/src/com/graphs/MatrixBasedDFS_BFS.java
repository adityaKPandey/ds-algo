package com.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MatrixBasedDFS_BFS {

	
	public void MatrixBasedDFS_BFS() {
		
	}

	private static void printNodesinBFSREcursive(int [] [] matrix , int n , int start) {

	}

	private static void bfsNonRecursive(int [][] matrix , int start , int n ) {

		//if(!visited[start]) {

		Set<Integer>toVisit = new HashSet<>();
		HashMap<Integer, Integer>m = new HashMap<>();
		
		boolean [] visited = new boolean[n];
		toVisit.add(start);
		do {

			for(int node : toVisit) {
				visited[node]  = true;
				System.out.print(node + " -> ");
			}

			Set<Integer>toVisit2 = new HashSet<>();
		   for(int node:toVisit)	
			for(int i = 0 ; i < n ; i++) {
				if(!visited[i] && matrix[node][i] > 0) {
					toVisit2.add(i);
				}
			}
		   
             toVisit.clear();
             toVisit.addAll(toVisit2);
		}while(!toVisit.isEmpty());
		//}

	}


	private static void printNodesinDFS(int [] [] matrix , int n , int start) {
		boolean [] visited = new boolean[n];

		dfsRecursive(matrix, start, visited, n);
	}

	private static void dfsRecursive(int [][]matrix , int current , boolean[]visited , int n) {

		if(!visited[current]) {
			visited[current]  = true;
			System.out.print(current + " -> ");
			for(int i = 0 ; i < n ; i++ ) {
				if(!visited[i] && matrix[current][i] > 0)
					dfsRecursive(matrix, i, visited , n);
			}  
		}
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
		printNodesinDFS(matrix, numOfNodes, 1);
		System.out.println("BFS:");
		bfsNonRecursive(matrix, 1, numOfNodes);
		System.out.println();
		
		bfsNonRecursive(matrix, 1, numOfNodes);
		System.out.println();
		int numOfNodes1 = 4;
		int [][] matrix1 = new int [] [] {
			{0,1,1,0},
			{1,0,1,1},
			{1,1,0,1},
			{0,1,1,1}

		};

		printNodesinDFS(matrix1, numOfNodes1, 1);
		System.out.println("BFS:");
		bfsNonRecursive(matrix1, 1, numOfNodes1);
		System.out.println();
		printNodesinDFS(matrix1, numOfNodes1, 2);

	}

}
