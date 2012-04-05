package org.learn.dsa.graph;

import java.util.ArrayList;

public class TSPGraph extends MSTGraph{

  public TSPGraph(){
    super();
  }
  
  /*
   * Using the 2-approximation algorithm
   * 1. Generate MST
   * 2. pre-order Tree walk on MST
   * 3. 
   * 
   */
  public void computeShortestPath(){
    // generate the MST
    mstw();
    dfs(root);
    
  }
  
  public void dfs(Vertex v){
    ArrayList<Vertex> childNodes = v.childNodes;
    
    for (Vertex child : childNodes) {
    
      if (child.wasVisited){
        dfs(child.parentVertex);
      }
      else{
        System.out.println(" Visiting " + child.label);
        child.wasVisited = true;
        dfs(child);
      }
      
    }
    
  }
}
