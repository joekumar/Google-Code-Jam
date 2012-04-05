package org.learn.dsa.graph;

import java.util.Stack;

/*
 * Graph contains vertices and Edges
 * Vertices are represented using class Vertex
 * Edges are represented using adjacency matrix 
 */

public class Graph {
	private Vertex vertexList[];
	private int adjMatrix [] [];
	private int nVertices;
	private final int MAX_VERT = 20;
	private Stack<Integer> dfsStack = new Stack <Integer>();
	
	public Graph(){
		vertexList = new Vertex [MAX_VERT];
		adjMatrix = new int[MAX_VERT][MAX_VERT];
		nVertices = 0;
		
		for (int i = 0; i< MAX_VERT; i++){
			for (int j =0; j < MAX_VERT; j++){
				adjMatrix [i][j] = 0;
			}
		}
	}

	public void addVertex(char vertex){
		 Vertex v1 = new Vertex(vertex);
		 vertexList[nVertices] = v1;
		 nVertices ++;
	}
	
	public void addEdge(int startNode, int endNode){
		adjMatrix[startNode] [endNode] = 1;
		adjMatrix[endNode] [startNode] = 1;
	}
	
	public void displayVertex(int vertexId){
		System.out.println(" Vertex is " +vertexList[vertexId].label);
	}
	
	public void displayGraphMatrix(){
		for (int i = 0; i < nVertices; i++){
			for (int j = 0; j < nVertices; j++){
					System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	/*
	 * Adjacent vertex is the vertex to which there is an edge hence there would be a 1
	 * in the column for that vertex in the adj matrix 
	 * 
	 */
	public int getUnvisitedVertex(int v){
		for ( int i = 0; i < nVertices; i++){
			if (adjMatrix [v] [i] == 1 && vertexList[i].wasVisited == false){
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * 1. Push the first vertex onto stack
	 * 2. Get the adjacent vertex [row] [j] for this and push into stack if itz not visited
	 * 3. If the adj vertex was visited, then pop it out.
	 * 
	 */
	public void dfs(){
	//	System.out.println(" +vertexList[vertexId] "+vertexList[0].label);
		vertexList[0].wasVisited = true;
		displayVertex(0);
		dfsStack.push(0);
		
			while(!dfsStack.isEmpty()){
			int adjVertex = getUnvisitedVertex((Integer)dfsStack.peek());
		//	System.out.println(" adjVertex " + adjVertex + " (Integer)dfsStack.peek() "+(Integer)dfsStack.peek());
			if (adjVertex != -1 ){
				vertexList[adjVertex].wasVisited = true;
				displayVertex(adjVertex);
				dfsStack.push(adjVertex);
			}
			else
				dfsStack.pop();
		}
		
			// re-initialize
		for (int j = 0; j < nVertices; j++){
			vertexList[j].wasVisited = false;
		}
	}
	
}
