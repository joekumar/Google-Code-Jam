package org.learn.dsa.suffixtree;

public class SuffixTreeApp {

  /*
   * References - 
   * 1. http://www.cs.mcgill.ca/~cs251/OldCourses/1997/topic7/ -> for the tree structure
   * 2. http://en.literateprograms.org/Suffix_tree_(Java) -> design
   * 
   */
  public static void main(String[] args) {
    SimpleSuffixTree simpleSuffixTree = new SimpleSuffixTree("googol");
    simpleSuffixTree.printTree(simpleSuffixTree.root);
  
   // CompactSuffixTree compactSuffixTree = new CompactSuffixTree("googol");
   // compactSuffixTree.printTree(compactSuffixTree.compactRoot);
  
  }

}
