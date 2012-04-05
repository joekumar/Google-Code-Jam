package org.learn.dsa.graph;


public class DistParent implements Comparable {

  int distance;
  Vertex parent;
  Vertex current;
  
  public DistParent(int dist, Vertex parent,Vertex current){
    this.distance = dist;
    this.parent = parent;
    this.current = current;
  }
  
  public int compareTo(Object o) {
    DistParent tempObj = (DistParent)o;

    if (tempObj.parent.isInTree == true){
      return 0;
    }
    
    if(this.distance > tempObj.distance)
        return 1;
    else if (this.distance  < tempObj.distance)
        return -1;
    else
        return 0;
}
  
}
