package org.learn.dsa.tree;

public class TreeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree binTree = new Tree();
		
		binTree.insert(50);
		binTree.insert(45);
		binTree.insert(75);
		binTree.insert(62);
		binTree.insert(83);
		binTree.insert(78);
		binTree.insert(86);
		binTree.insert(79);
	
//		binTree.findNPrint(12);
//		binTree.findNPrint(13);
//		binTree.findNPrint(30);
		
		binTree.inOrder(binTree.getRoot());
		
		int max = binTree.maxValue();
		int min = binTree.minValue();
		
		//binTree.delete(max);
		//binTree.delete(min);
		binTree.delete(75);
		
		binTree.inOrder(binTree.getRoot());
		
	}

}
