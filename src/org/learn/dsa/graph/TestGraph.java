package org.learn.dsa.graph;

public class TestGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addVertex('a');
		graph.addVertex('b');
		graph.addVertex('c');
		graph.addVertex('d');
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);

		graph.displayGraphMatrix();
//		graph.displayVertex(0);
//		graph.displayVertex(1);
//		graph.displayVertex(2);
//		graph.displayVertex(3);
		graph.dfs();
		
	}

}
