package com.greedy;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphColorSelection {

	static  final String JAN = "Jan" ;
	static  final String FEB = "Feb" ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	       
	         
		
		// List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4),
                new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3),
                new Edge(2, 3), new Edge(2, 4)
        );
 
        // total number of nodes in the graph
        final int N = 6;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, N);
 
        // color graph using the greedy algorithm
        colorGraph(graph, N);

	}




	// Function to assign colors to vertices of a graph 0 to N-1
	public static void colorGraph(Graph graph, int N)
	{
		// keep track of the color assigned to each vertex
		Map<Integer, Integer> result = new HashMap<>();
		

		// assign a color to vertex one by one
		for (int u = 0; u < N; u++) {
		    Set<Integer> colors = IntStream.range(0, N).boxed().collect(Collectors.toSet());	
		    
		    //  IntStream.range(0, N).toArray()
		   
			List<Integer> neighbors = graph.adjacencyList.get(u);
			
			for(Integer key : neighbors) {
				if(result.containsKey(key))
					colors.remove(result.get(key));
				
			}
			result.put(u, colors.iterator().next());
		}
		
		System.out.println("Result:"+result);
		List<Integer>list = new ArrayList<>(3);
		list.add(1);
		list.add(2);
		list.add(1,10);
		Integer [] arr = {1 , 2 ,3};
				//(Integer[]) list.toArray();
		list = Arrays.asList(arr);
		System.out.println(list);
		 String DAY_REGEX = "^23" ;
	      Pattern pattern = Pattern.compile(DAY_REGEX);
	      System.out.println(pattern.matcher("23rd Jan 2013").matches());
	      
	      
	}
	
	
}


class Edge{

	int source , destination;

	public Edge(int source , int destination){

		this.source = source;
		this.destination = destination;

	}
}

class Graph{

	List<List<Integer>> adjacencyList;

	public Graph(List<Edge>edges , int N) {

		adjacencyList = new ArrayList<List<Integer>>(N);
		for(int i = 0 ; i < N ; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for(Edge edge : edges ) {
			
			adjacencyList.get(edge.source).add(edge.destination);
			adjacencyList.get(edge.destination).add(edge.source);

		}

	}

}
