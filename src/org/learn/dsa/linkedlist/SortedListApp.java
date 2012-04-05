package org.learn.dsa.linkedlist;

public class SortedListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedList sortedList = new SortedList();
		
		sortedList.insert(50);
		sortedList.insert(40);
		sortedList.insert(45);
		sortedList.insert(20);
		sortedList.insert(30);
		sortedList.insert(23);
		sortedList.insert(4);
		
		sortedList.displayList();
		
		sortedList.remove(45);
		System.out.println("");
		sortedList.remove(176);
		System.out.println("");
		sortedList.displayList();
	}

}
