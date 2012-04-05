package org.learn.dsa.linkedlist;

public class SortedList {

	DELink first = null;

	public SortedList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	/*
	 * 1. Instantiate New link
	 * 2. Keep moving till you get the link whose value is > new link's key
	 * 3. Now change the previous.next to point to NewLink and newLink.next to current
	 */
	public void insert(long key) {
		DELink newLink = new DELink(key);
		DELink previous = first;
		DELink current = first;

		if (first == null) {
			newLink.next = first;
			first = newLink;
		} else {
			while (newLink.next == null) {
				if (current.getLData() <= key) {
					current = current.next;
					previous.next = current;
				} else {
					if (current == first) {
						newLink.next = current;
						first = newLink;
					} else {
						previous.next = newLink;
						newLink.next = current;
					}
				}
			}
		}
	}

	public void remove(int longKey) {
		DELink current = first;
		DELink previous = first;
		
		while (current.next != null){
			if (current.getLData() == longKey){
				previous.next = current.next;
				return;
			}
			else{
				previous = current;
				current = current.next;
			}
		}
			System.out.println(" Element "+longKey+" not found ");
	 }

	public void displayList() {
		DELink current = first;
		System.out.print(" Sorted List \t");
		while (current != null) {
			current.displayDELink();
			current = current.next;
		}
	}

}
