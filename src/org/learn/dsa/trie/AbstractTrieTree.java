package org.learn.dsa.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTrieTree {

  /*
   * References - 1. http://www.cs.mcgill.ca/~cs251/OldCourses/1997/topic7/ ->
   * for the tree structure 2. http://en.literateprograms.org/Suffix_tree_(Java)
   * -> design
   */

  protected String strInput = null;

  protected TrieTreeNode root = null;
  protected TrieTreeNode finalNode = new TrieTreeNode(null,'$',0);

  protected int depthOfTree = 0;

  protected char charBranchValue;

  protected ArrayList<String> alBranch = new ArrayList<String>();

  protected String strBranchValue = "";

  protected void addEndSuffixToString(String text) {
    if (text.endsWith("$"))
      strInput = text;
    else
      strInput = text + "$";
  }

  abstract protected void constructTree();

  private void constructPrintTree(TrieTreeNode startNode) {
    List<TrieTreeNode> childNodes = startNode.childNodeList;
    Iterator<TrieTreeNode> childIter = childNodes.iterator();
    char charNodeValue;

    while (childIter.hasNext()) {

      TrieTreeNode child = childIter.next();
      if (child.isVisited == false) {
        child.isVisited = true;
        charNodeValue = child.nodeValue;
        strBranchValue = strBranchValue + String.valueOf(charNodeValue);
        // System.out.println(" child " + charNodeValue + " at depth " +
        // child.depth);

        if (child.childNodeList.contains(finalNode) && child.childNodeList.size() > 1) {
          for (int i = 0; i < child.childNodeList.size(); i++){
            child.childNodeList.get(i).strPrefix = strBranchValue;
          }
          alBranch.add(strBranchValue);
        }
        
        if (charNodeValue == '$'){
          alBranch.add(child.strPrefix + strBranchValue);
          strBranchValue = "";
        }

        constructPrintTree(child);
      }
    }

  }

  /*
   * This method will print the Suffix Tree structure Recursive
   */
  protected void printTree(TrieTreeNode startNode) {
    constructPrintTree(startNode);
    System.out.println(" Values in Branch " + alBranch);
  }
  
  public void printTree(){
    printTree(root);
  }
}
