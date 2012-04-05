package org.learn.dsa.graph;


public class Edge implements Comparable<Edge>{

  /*int srcVertex;
  int destVertex;
  int weight;
  
  public Edge(int src, int dest, int weight){
    srcVertex = src;
    destVertex = dest;
    this.weight = weight;
  }
  
  
  public int compareTo(Object o) {
    Edge tempEdge = (Edge)o;

    if(this.weight > tempEdge.weight)
        return 1;
    else if (this.weight < tempEdge.weight)
        return -1;
    else
        return 0;
}*/
  

    Node from, to;
    int weight;

    Edge(Node f, Node t, int w){
        from = f;
        to = t;
        weight = w;
    }

    public int compareTo(Edge e){
        return weight - e.weight;
    }
 }

  
