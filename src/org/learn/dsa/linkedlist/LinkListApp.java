package org.learn.dsa.linkedlist;

public class LinkListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList lList = new LinkList();
		
		lList.insertFirst(2, 1.414);
		lList.insertFirst(3, 1.732);
		lList.insertFirst(4, 2);
		lList.insertFirst(5, 2.25);
		
		lList.displayList();
		
	/*	while (!lList.isEmpty()){
			System.out.print(" deleting ... ");
			Link tmpLink = lList.deleteFirst();
			tmpLink.displayLink();
			System.out.println("");
		}
	*/
		lList.delete(4);
		lList.displayList();
	}

}
