package org.learn.dsa.linkedlist;

public class DELink {
	
	private long lData;
	public DELink next;
	
	public DELink (long d){
		lData = d;
	}
	
	public void displayDELink(){
		System.out.print(" lData :"+lData);
	}
	
	/**
	 * @return the lData
	 */
	public long getLData() {
		return lData;
	}
	/**
	 * @param data the lData to set
	 */
	public void setLData(long data) {
		lData = data;
	}
	
	
}
