package org.learn.dsa.graph;

public class ShortestPathApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ShortestPathGraph tspgraph = new ShortestPathGraph();
    /*tspgraph.addVertex('A');
    tspgraph.addVertex('B');
    tspgraph.addVertex('C');
    tspgraph.addVertex('D');
    tspgraph.addVertex('E');
    
    tspgraph.addEdge(0, 1, 50);
    tspgraph.addEdge(0, 3, 80);
    tspgraph.addEdge(1,2, 60);
    tspgraph.addEdge(1, 3, 90);
    tspgraph.addEdge(2, 4, 40);
    tspgraph.addEdge(3, 2, 20);
    tspgraph.addEdge(3, 4, 70);
    tspgraph.addEdge(4, 1, 50);
    */
    
    tspgraph.addVertex('A');
    tspgraph.addVertex('B');
    tspgraph.addVertex('C');
  
    
    tspgraph.addEdge(0, 1, 27);
    tspgraph.addEdge(1, 0, 2);
    tspgraph.addEdge(0, 2, 47);
    tspgraph.addEdge(2, 0, 97);
    tspgraph.addEdge(2, 1, 11);
    tspgraph.addEdge(1, 2, 37);
    
    System.out.println(" Generating the shortest path ");
    tspgraph.computeShortestPath();
    
  }

}
