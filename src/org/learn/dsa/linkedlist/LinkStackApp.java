package org.learn.dsa.linkedlist;

public class LinkStackApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkStack linkStack = new LinkStack();
		
		linkStack.push(10);
		linkStack.push(20);
		linkStack.push(30);
		
		linkStack.displayStack();
		
		linkStack.push(40);
		linkStack.push(50);
		
		linkStack.displayStack();
		
		linkStack.pop();
		linkStack.pop();
		
		linkStack.displayStack();
	}

}
