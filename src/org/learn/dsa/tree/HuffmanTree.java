package org.learn.dsa.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class HuffmanTree implements Comparable<HuffmanTree> {

	HuffmanNode root;
	int treeCost;
	Map<Character,String> hmCodeTable = new LinkedHashMap<Character,String>();

	public HuffmanTree(){
	}

	public void infixTraversal(String strVal,HuffmanNode node){
		if (node == null) {
			return;
		}
		//strCode = strCode + strVal;
		infixTraversal("0",node.leftChild);
		visitNode(node);
		//strCode = strCode + strVal;
		infixTraversal("1",node.rightChild);
	}
	
	/*
	 * Do a DFS on the constructed huffman tree to generate the codes
	 * base case - if all nodes are traversed, we are done.
	 * 
	 */
	public void dfsTraverseTree(HuffmanNode node){
	  if (node == null){
	    return;
	  }
	  
	  String strParentCode = node.strNodeCode;
	  
	  if (node.leftChild != null && node.leftChild.wasVisited == false){
	    node = node.leftChild;
	    node.strNodeCode = strParentCode + "0";
	    visitNode(node);
	    dfsTraverseTree(node);
	  }
	  
	  else if (node.rightChild != null && node.rightChild.wasVisited == false){
	    node = node.rightChild;
	    node.strNodeCode = strParentCode + "1";
	    visitNode(node);
	    dfsTraverseTree(node);
	  }
        
	  dfsTraverseTree(node.parent); 
	}
	
	public void visitNode(HuffmanNode node){
	  node.wasVisited = true;
	  if(node.isLeaf) {
	//	System.out.print(" Char: "+node.character + "-"+node.strNodeCode );
		hmCodeTable.put(node.character, node.strNodeCode);
		}
		//treeCost = treeCost + node.frequency;
	}
	
	public int compareTo(HuffmanTree ht1) {
		int ht1cost = ht1.treeCost;

		if (this.treeCost < ht1cost)
			return -1;
		else if (this.treeCost> ht1cost )
			return 1;
		else
			return 0;
	}
	
	public String toString(){
		return root.toString();
	}
}
