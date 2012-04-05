package org.learn.dsa.linkedlist;

public class DELinkListApp {
	
	public static void main(String args[]){
		DELinkList deLinkList = new DELinkList();
		
		deLinkList.insertFirst(2);
		deLinkList.insertFirst(4);
		deLinkList.insertFirst(6);
		deLinkList.insertFirst(8);
		deLinkList.insertFirst(10);
		
		deLinkList.insertLast(20);
		deLinkList.insertLast(40);
		
		deLinkList.displayList();
		
		deLinkList.deleteFirst();
		deLinkList.deleteFirst();
		
		deLinkList.displayList();
	}

}
