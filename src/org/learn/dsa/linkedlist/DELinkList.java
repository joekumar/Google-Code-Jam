package org.learn.dsa.linkedlist;

public class DELinkList {
	
	private DELink first;
	private DELink last;
	
	public DELinkList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(long dd){
		DELink newdendlink = new DELink(dd);
		
		if (isEmpty()){
			last = newdendlink;
		}
		newdendlink.next = first;
		first = newdendlink;
	}
	
	public void insertLast(long dd){
		DELink newdendlink = new DELink(dd);
		
		if (isEmpty()){
			first = newdendlink;
		} else
			last.next = newdendlink;
		last = newdendlink;
		
	}
	
	public long deleteFirst(){
		long temp = first.getLData();
		
		if (first.next == null)
			last = null;
		
		first = first.next;
		return temp;
		
	}
	
	public void displayList(){
		System.out.print(" Double Ended Link List (first --> last): ");
		DELink current = first;
		
		while (current != null){
			current.displayDELink();
			current = current.next;
		}
		
		System.out.println("");
	}

}
