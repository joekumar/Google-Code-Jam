package org.learn.dsa.graph;

public class TSPGraphApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    /* TSPGraph tspgraph = new TSPGraph();
    tspgraph.addVertex('A');
    tspgraph.addVertex('B');
    tspgraph.addVertex('C');
   tspgraph.addVertex('D');
    tspgraph.addVertex('E');
    tspgraph.addVertex('F');
   
    
    tspgraph.addEdge(0, 1, 27);
    tspgraph.addEdge(1, 0, 2);
    tspgraph.addEdge(0, 2, 47);
    tspgraph.addEdge(2, 0, 97);
    tspgraph.addEdge(2, 1, 11);
    tspgraph.addEdge(1, 2, 37);
    tspgraph.addEdge(0, 1, 6);
    tspgraph.addEdge(0, 3, 4);
    tspgraph.addEdge(1,2, 10);
    tspgraph.addEdge(1, 3, 7);
    tspgraph.addEdge(1, 4, 7);
    tspgraph.addEdge(2, 3, 8);
    tspgraph.addEdge(2, 4, 5);
    tspgraph.addEdge(2, 5, 6);
    tspgraph.addEdge(3, 4, 12);
    tspgraph.addEdge(4, 5, 7);
    */
    
    FloydWarshall floydWarshall = new FloydWarshall();
    Node n1 = new Node(0);
    Node n2 = new Node(1);
    Node n3 = new Node(2);
    
    Edge e1 = new Edge(n1,n2,27);
    Edge e2 = new Edge(n2,n1,2);
    Edge e3 = new Edge(n1,n3,47);
    Edge e4 = new Edge(n3,n1,93);
    Edge e5 = new Edge(n2,n3,35);
    Edge e6 = new Edge(n3,n2,11);
    
    Node[] nodes = {n1,n2,n3};
    Edge[] edges = {e1,e2,e3,e4,e5,e6};
    floydWarshall.calcShortestPaths(nodes, edges);
 
    System.out.println(" Generating the TSP ");
    //tspgraph.computeShortestPath();
  }

}
