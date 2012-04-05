package org.learn.dsa.linkedlist;

public class LinkQueue {
	
	private DELinkList deLinkList;
	
	public LinkQueue(){
		deLinkList = new DELinkList();
	}
	
	public boolean isEmpty(){
		return deLinkList.isEmpty();
	}
	
	public void insert(long l){
		deLinkList.insertLast(l);
	}
	
	public void remove(){
		deLinkList.deleteFirst();
	}
	
	public void displayQueue(){
		System.out.println(" Queue from beginning to end: ");
		deLinkList.displayList();
	}

}
