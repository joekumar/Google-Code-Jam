package org.learn.dsa.graph;

import java.util.Comparator;


public class VertexComparator implements Comparator<Vertex> {

  public int compare(Vertex v1, Vertex v2) {

    if (v1.parentDistance > v2.parentDistance){
      return 1;
 }
 else if (v1.parentDistance < v2.parentDistance){
   return -1;
 }
 else
   return 0;
   
   /* if ((v1.isInTree && v2.isInTree) || (!v1.isInTree && !v2.isInTree)){
      if (v1.parentDistance > v2.parentDistance){
           return 1;
      }
      else if (v1.parentDistance < v2.parentDistance){
        return -1;
      }
      else
        return 0;
    }
    
    else if (v1.isInTree) {
      return 1;
    }
    
    else if (v2.isInTree) {
      return -1;
    }
    
    else
      return 0;
  */
  }


  
}
