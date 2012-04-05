package org.learn.dsa.linkedlist;

public class LinkStack {
	
	private LinkList linkList;
	
	public LinkStack(){
		linkList = new LinkList();
	}
	
	public void push (long l){
		linkList.insertFirst(1, l);
	}
	
	public void pop (){
		linkList.deleteFirst();
	}
	
	public double peek (){
		return linkList.getFirst().getDData();
	}
	
	public void displayStack(){
		linkList.displayList();
	}

}
