package org.learn.dsa.suffixtree;

import java.util.Iterator;
import java.util.List;

public class CompactSuffixTree extends AbstractSuffixTree {
  
  SuffixTreeNode compactRoot;
  String strBuffer = "";
  
  public CompactSuffixTree(String strInput){
    super(strInput);
    constructTree();
  }

  /*
   * Create the root node and insert all suffixes into this tree, counting the
   * paths.
   */
  public void constructTree(){
    SimpleSuffixTree simpleSuffixTree = new SimpleSuffixTree(strInput);
    SuffixTreeNode sfTreeNode = simpleSuffixTree.getSuffixTree();
    compactRoot = new SuffixTreeNode();
    createSuffixTree(compactRoot,sfTreeNode);
    System.out.println(" All DOne");
  }
  
  /*
   * Recursive - base case - if wasVisited is true for all edges 
   * 1. Perform a DFS. If node has childNodes, then create a new node for it and attach it to root node.
   * 2. else if child node has only 1 node, accumulate and keep going till we hit more than 1 node and create a new node for the accumulated ones.
   * 
   */
  public void createSuffixTree(SuffixTreeNode compactRootNode,SuffixTreeNode sfTreeNode){
    
    List<SuffixTreeNode> childNodes = sfTreeNode.childNodeList;
    Iterator<SuffixTreeNode> iter = childNodes.iterator();
    
    while (iter.hasNext()){
      SuffixTreeNode child = iter.next();
      
      if (child.incomingEdge.isVisited == false){
        child.incomingEdge.isVisited = true;
        
        if (child.childNodeList.size() > 1 || child.toString().equals("$")){
          strBuffer = strBuffer + child.strNodeValue;
          SuffixTreeNode sfxNode = new SuffixTreeNode(compactRootNode,strBuffer,compactRootNode.depth+1);
          compactRootNode.childNodeList.add(sfxNode);
          strBuffer = "";
          createSuffixTree(sfxNode,child);
        }
        else{
          strBuffer = strBuffer + child.strNodeValue;
          createSuffixTree(compactRootNode,child);
        }
      }
      
    }
    
  }
  
}
