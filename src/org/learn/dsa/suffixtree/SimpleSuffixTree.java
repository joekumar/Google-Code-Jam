package org.learn.dsa.suffixtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleSuffixTree extends AbstractSuffixTree {

  public SimpleSuffixTree(String text) {
    super(text);
    depthOfTree = text.length();
    constructTree();
  }

  /*
   * Create the root node and insert all suffixes into this tree, counting the
   * paths.
   */
  public void constructTree() {
    super.root = new SuffixTreeNode();
    int length = super.strInput.length();
    int pathIndex = 0;

    for (int i = 0; i < length; i++) {
      List<String> suffixStringList = new ArrayList<String>();
      for (int k = i; k < length; k++) {
        suffixStringList.add(String.valueOf(super.strInput.charAt(k)));
      }
      addSuffix(suffixStringList, pathIndex);
    }

  }

  /*
   * The addSuffix method of the node takes two parameters: suffix: The suffix
   * to insert into the suffix tree, will be inserted behind the maximum prefix
   * of the suffix found in the tree. pathIndex: The path index for labeling the
   * leaf at the end of the path of the suffix added.
   * 
   * How it works - Recursivley find the node to insert at. Insert new nodes for
   * the suffix to insert below the node found.
   */
  public void addSuffix(List<String> suffix, int pathIndex) {
    SuffixTreeNode newNode = searchNode(root, suffix);
    insertNewNode(newNode, suffix);

  }

  /*
   * Recursive method to determine where we want to insert the new node. Base
   * case -if list "suffix" is exhausted, then we return
   */
  public SuffixTreeNode searchNode(SuffixTreeNode node, List<String> suffix) {

    if (suffix.size() == 0) {
      return node;
    }

    List<SuffixTreeNode> childNodes = node.childNodeList;
    Iterator<SuffixTreeNode> childIter = childNodes.iterator();

    while (childIter.hasNext()) {
      SuffixTreeNode child = childIter.next();
      if (child.incomingEdge.strEdgeValue.equals(suffix.get(0))) {
        suffix.remove(0);
        node = searchNode(child, suffix);
      }
    }

    return node;
  }

  /*
   * Inserts new Node in the tree.
   */
  public void insertNewNode(SuffixTreeNode newNode, List<String> suffix) {
    for (String suffixChar : suffix) {
      SuffixTreeNode newChildNode = new SuffixTreeNode(newNode, suffixChar, newNode.depth + 1);
      newNode.childNodeList.add(newChildNode);
      newNode = newChildNode;
    }

  }

  public String toString() {
    return String.valueOf(depthOfTree);
  }
  
  /*
   * returns the Root of the constructed tree so we can traverse.
   * might have to re-initialize the isVisited values
   */
  public SuffixTreeNode getSuffixTree(){
    return root;
  }

  

}
