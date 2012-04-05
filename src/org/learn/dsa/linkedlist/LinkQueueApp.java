package org.learn.dsa.linkedlist;

public class LinkQueueApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkQueue linkQueue = new LinkQueue();
		
		linkQueue.insert(10);
		linkQueue.insert(20);
		linkQueue.insert(30);
		linkQueue.displayQueue();
		
		linkQueue.insert(40);
		linkQueue.insert(50);
		linkQueue.displayQueue();
		
		linkQueue.remove();
		linkQueue.remove();
		linkQueue.displayQueue();
	}

}
