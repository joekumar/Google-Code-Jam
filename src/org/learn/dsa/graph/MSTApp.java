package org.learn.dsa.graph;

public class MSTApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MSTGraph mstGraph = new MSTGraph();
    mstGraph.addVertex('A');
    mstGraph.addVertex('B');
    mstGraph.addVertex('C');
    mstGraph.addVertex('D');
    mstGraph.addVertex('E');
    mstGraph.addVertex('F');
    
    mstGraph.addEdge(0, 1, 6);
    mstGraph.addEdge(0, 3, 4);
    mstGraph.addEdge(1,2, 10);
    mstGraph.addEdge(1, 3, 7);
    mstGraph.addEdge(1, 4, 7);
    mstGraph.addEdge(2, 3, 8);
    mstGraph.addEdge(2, 4, 5);
    mstGraph.addEdge(2, 5, 6);
    mstGraph.addEdge(3, 4, 12);
    mstGraph.addEdge(4, 5, 7);
    
    System.out.println(" Generating the MST ");
    mstGraph.mstw();
    
    
  }

}
