package org.learn.dsa.graph;

import java.util.ArrayList;


/*
 * Vertex can contain some data. It is a node.
 */
public class Vertex{
  public char label;

  public boolean wasVisited;

  public boolean isInTree;

  public int matrixRowNum;

  Vertex parentVertex;

  private int INFINITY = 100000;

  public int parentDistance = INFINITY;
  
  ArrayList<Vertex> childNodes;

  public Vertex(char lab) {
    label = lab;
    wasVisited = false;
    isInTree = false;
    childNodes = new ArrayList<Vertex>();
  }

  public Vertex(char lab, int mRowNum) {
    label = lab;
    matrixRowNum = mRowNum;
    wasVisited = false;
    isInTree = false;
  }

  public boolean equals(Object obj) {
    Vertex v = (Vertex)obj;
    boolean blval = this.parentDistance == v.parentDistance; 
    return blval;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
    // TODO Auto-generated method stub
    return this.hashCode();
}

  public String toString(){
    return "label " +label +" dist "+parentDistance;
  }
}
