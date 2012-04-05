package org.learn.dsa.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrieTree extends AbstractTrieTree {

  public TrieTree(){
    
  }
  
  public TrieTree(String text) {
    insertNodeInTrieTree(text);
  }
  
  public void insertNodeInTrieTree(String input){
    addEndSuffixToString(input);
    depthOfTree = input.length();
    constructTree();
    
  }

  /*
   * Create the root node and insert all suffixes into this tree, counting the
   * paths.
   */
  protected void constructTree() {
    
    if (super.root == null ){
    super.root = new TrieTreeNode();
    }
    
    int length = super.strInput.length();
    int pathIndex = 0;

    //for (int i = 0; i < length; i++) {
      List<Character> suffixCharList = new ArrayList<Character>();
      for (int k = 0; k < length; k++) {
        suffixCharList.add(super.strInput.charAt(k));
      }
      addSuffix(suffixCharList, pathIndex);
    //}

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
  private void addSuffix(List<Character> suffix, int pathIndex) {
    TrieTreeNode newNode = searchNode(root, suffix);
    insertNewNode(newNode, suffix);

  }

  /*
   * Recursive method to determine where we want to insert the new node. Base
   * case -if list "suffix" is exhausted, then we return
   */
  private TrieTreeNode searchNode(TrieTreeNode node, List<Character> suffix) {

    if (suffix.size() == 0) {
      return node;
    }

    List<TrieTreeNode> childNodes = node.childNodeList;
    Iterator<TrieTreeNode> childIter = childNodes.iterator();

    while (childIter.hasNext()) {
      TrieTreeNode child = childIter.next();
      if (child.nodeValue == suffix.get(0)) {
        suffix.remove(0);
        node = searchNode(child, suffix);
      }
    }

    return node;
  }

  /*
   * Inserts new Node in the tree.
   */
  private void insertNewNode(TrieTreeNode newNode, List<Character> suffix) {
    for (char suffixChar : suffix) {
      TrieTreeNode newChildNode = new TrieTreeNode(newNode, suffixChar, newNode.depth + 1);
      newNode.childNodeList.add(newChildNode);
      newNode = newChildNode;
    }

  }

  public String toString() {
    return String.valueOf(depthOfTree);
  }

  /*
   * returns the Root of the constructed tree so we can traverse. might have to
   * re-initialize the isVisited values
   */
  private TrieTreeNode getTrieTree() {
    return root;
  }

}
