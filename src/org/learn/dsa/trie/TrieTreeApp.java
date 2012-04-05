package org.learn.dsa.trie;

public class TrieTreeApp {

  /**
   * @param args
   */
  public static void main(String[] args) {

    TrieTree trieTree = new TrieTree("googol");
    trieTree.insertNodeInTrieTree("go");
    trieTree.insertNodeInTrieTree("goal");
    trieTree.insertNodeInTrieTree("bake");
    trieTree.printTree();
  
  }

}
