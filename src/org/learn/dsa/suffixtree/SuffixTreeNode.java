package org.learn.dsa.suffixtree;

import java.util.ArrayList;
import java.util.List;

public class SuffixTreeNode {

  String strNodeValue = null;
  SuffixTreeEdge incomingEdge = null;
  SuffixTreeNode parentNode = null;
  List<SuffixTreeNode> childNodeList = new ArrayList<SuffixTreeNode>();
  int depth;

  public SuffixTreeNode() {

  }

  public  SuffixTreeNode(SuffixTreeNode parent, String strVal, int depthval) {
    strNodeValue = strVal;
    depth = depthval;
    parentNode = parent;
    incomingEdge = new SuffixTreeEdge(strVal);
  }
  
  public String getEdgeValue(){
    return incomingEdge.strEdgeValue;
  }
  
  public String toString(){
    return getEdgeValue();
  }
  
}
