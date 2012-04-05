package org.learn.dsa.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieTreeNode {
  char nodeValue;
  boolean isVisited;
  TrieTreeNode parentNode = null;
  String strPrefix = "";
  List<TrieTreeNode> childNodeList = new ArrayList<TrieTreeNode>();

  int depth;
  
  public TrieTreeNode(){
    
  }

  public TrieTreeNode(TrieTreeNode parent, char nodeVal, int depthval) {
    this.parentNode = parent;
    this.nodeValue = nodeVal;
    this.depth = depthval;
    this.isVisited = false;
  }

 
  public char getTrieNodeValue(){
    return nodeValue;
  }
  
  
  
  @Override
  public boolean equals(Object obj) {
    TrieTreeNode temp = (TrieTreeNode)obj;
    
    if (temp.nodeValue ==  this.nodeValue){
      return true;
    }
    else
      return false;
    
  }

  @Override
  public int hashCode() {
   return nodeValue;
  }

  public String toString(){
    return String.valueOf(getTrieNodeValue());
  }
  
}
