package org.learn.dsa.linkedlist;

public class Link {

	private int iData;
	private double dData;
	public Link next;
	
	public Link(int id, double dd){
		iData = id;
		dData = dd;
	}
	
	public void displayLink(){
		System.out.print("{"+iData+ ", " +dData+ "} ");
	}

	/**
	 * @return the iData
	 */
	public int getIData() {
		return iData;
	}

	/**
	 * @param data the iData to set
	 */
	public void setIData(int data) {
		iData = data;
	}

	/**
	 * @return the dData
	 */
	public double getDData() {
		return dData;
	}

	/**
	 * @param data the dData to set
	 */
	public void setDData(double data) {
		dData = data;
	}
}
