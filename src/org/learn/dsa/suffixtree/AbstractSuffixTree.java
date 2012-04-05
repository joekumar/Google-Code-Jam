package org.learn.dsa.suffixtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * References - 
 * 1. http://www.cs.mcgill.ca/~cs251/OldCourses/1997/topic7/ -> for the tree structure
 * 2. http://en.literateprograms.org/Suffix_tree_(Java) -> design
 * 
 */

public abstract class AbstractSuffixTree {
  protected String strInput = null;
  protected SuffixTreeNode root = null;
  protected int depthOfTree = 0;
  protected String strBranchValue = "";
  protected ArrayList<String> alBranch = new ArrayList<String>();
  
  public AbstractSuffixTree(String text) {
    if (text.endsWith("$"))
      strInput = text;
    else
      strInput = text + "$";
  }

  abstract public void constructTree() ;
  
  /*
   * This method will print the Suffix Tree structure Recursive
   * 
   */
  public void printTree(SuffixTreeNode startNode) {
    List<SuffixTreeNode> childNodes = startNode.childNodeList;
    Iterator<SuffixTreeNode> childIter = childNodes.iterator();
    String strNodeValue = "";

    while (childIter.hasNext()) {
     
      SuffixTreeNode child = childIter.next();
      if (child.incomingEdge.isVisited == false ) {
        child.incomingEdge.isVisited = true;

        if (child.parentNode.childNodeList.size() > 1 && child.depth > 1) {
          strNodeValue =  child.parentNode.incomingEdge.strEdgeValue + child;
          strBranchValue = strNodeValue;

        } else {
          strNodeValue = child.toString();
          strBranchValue =  strBranchValue + strNodeValue;
          child.incomingEdge.strEdgeValue = strBranchValue;
        }
        
        System.out.println(" child " + strNodeValue + " at depth " + child.depth);
        if (strNodeValue.endsWith("$") ) {
          alBranch.add(strBranchValue);
          strBranchValue = "";
        }
        printTree(child);
      }
    }

    System.out.println(" Values in Branch " + alBranch);

  }
    
}
