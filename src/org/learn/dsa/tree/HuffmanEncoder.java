package org.learn.dsa.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoder {
	HashMap<String,HuffmanNode> hmFrequencyTable = new HashMap<String,HuffmanNode>();
	PriorityQueue<HuffmanNode> treeQueue = new PriorityQueue<HuffmanNode>();
	HuffmanTree huffmanTree = new HuffmanTree();
	
	public void readAndCreateFrequencyTable(String strSentence){
		Scanner scan = new Scanner(strSentence);
		scan.useDelimiter("");
		
		while(scan.hasNext()){
			char c = scan.next().charAt(0);
			String strC = String.valueOf(c);
			HuffmanNode hn;
			boolean isCharDuplicate = hmFrequencyTable.containsKey(strC);
			
			if (isCharDuplicate){
				hn = hmFrequencyTable.get(strC);
				hn.frequency++;
			}
			else{
				hn = new HuffmanNode(c);
				hmFrequencyTable.put(strC, hn);
			}
			hn.isLeaf = true;
		}
		populatePriorityQueue();
		//displayQueue();
		constructHuffmanTree();
	}
	
	public void populatePriorityQueue(){
		
		Iterator<String> hmIterator = hmFrequencyTable.keySet().iterator(); 
		while(hmIterator.hasNext()){
			String strKey = hmIterator.next();
			/*HuffmanTree hfTree = new HuffmanTree();
			hfTree.setRootNode(hmFrequencyTable.get(strKey));
			*/
			treeQueue.add(hmFrequencyTable.get(strKey));
		}
	}
	
	public void displayQueue(){
		Iterator<HuffmanNode> iter = treeQueue.iterator();
		
		while(iter.hasNext()){
			System.out.println(" element: "+treeQueue.peek() );
			iter.next();
		}
	}
	/*
	public void constructHuffmanTree(){
Iterator iter = treeQueue.iterator();
		System.out.println(" inside .... "+treeQueue.size() + " values "+hmFrequencyTable);
		while(treeQueue.size() != 1){
			HuffmanTree hfTree1 = treeQueue.poll() ;
			HuffmanTree hfTree2 = treeQueue.poll() ;
			
			HuffmanNode parentNode = new HuffmanNode();
			parentNode.frequency = hfTree1.treeCost + hfTree2.treeCost;
			parentNode.leftChild = hfTree1.root;
			parentNode.rightChild = hfTree2.root;
			
			HuffmanTree htTemp = new HuffmanTree();
			htTemp.root = parentNode;
			htTemp.treeCost = parentNode.frequency;
			treeQueue.add(htTemp);
		}
		
		HuffmanTree htTemp = treeQueue.peek();
		htTemp.displayTree();
		System.out.println("");
		System.out.println(" Code table " + htTemp.hmCodeTable);
	}
	*/
	
	/*
	 * Constructing  huffman tree should be recursive
	 * base case - treeQueue is empty
	 */
	
	public void constructHuffmanTree(){
	  
	  if (treeQueue.size() == 1){
	    HuffmanNode parentNode = treeQueue.poll() ;
	    parentNode.strNodeCode = "";
	    huffmanTree.root = parentNode;
	    return;
	  }
	  
	  HuffmanNode hm1 = treeQueue.poll() ;
	  HuffmanNode hm2 = treeQueue.poll() ;
	  
	  HuffmanNode parentNode = new HuffmanNode();
      parentNode.frequency = hm1.frequency + hm2.frequency;
      hm1.parent = parentNode;
      hm2.parent = parentNode;
      parentNode.leftChild = hm1;
      parentNode.rightChild = hm2;
      
      
      treeQueue.add(parentNode);
      
      constructHuffmanTree();
	}
	
	/*
	 * Does a DFS traversal of HuffmanTree which populates a hashmap of the codes.
	 * Then print this hashmap
	 */
	public void printHuffmanCode(){
	  huffmanTree.dfsTraverseTree(huffmanTree.root);
	  Iterator<Character> iterCode = huffmanTree.hmCodeTable.keySet().iterator();
	  
	  while (iterCode.hasNext()){
	    Character charVal = iterCode.next();
	    System.out.println(" Code for "+ charVal + " is - "+huffmanTree.hmCodeTable.get(charVal));
	  }
	  
	}
}
