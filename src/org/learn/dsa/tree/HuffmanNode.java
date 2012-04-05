package org.learn.dsa.tree;

public class HuffmanNode implements Comparable<HuffmanNode>{
	char character;
	int frequency;
	boolean isLeaf;
	HuffmanNode leftChild;
	HuffmanNode rightChild;
	HuffmanNode parent;
	boolean wasVisited;
	String strNodeCode;
	
	public HuffmanNode(char c){
		this.character = c;
		frequency = 1;
		isLeaf = true;
	}
	
	public HuffmanNode(){
		
	}
	
	public int compareTo(HuffmanNode ht1) {
//System.out.println(" comparing... " +ht1 + " ahainst  "+this);
		int ht1cost = ht1.frequency;

		if (this.frequency < ht1cost)
			return -1;
		else if (this.frequency >  ht1cost )
			return 1;
		else
				return 0;
	}
	
	public int hashCode() {
		return this.hashCode();
	}

	public String toString(){
		return character+":"+frequency;
	}
}
