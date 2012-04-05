package org.learn.dsa.recursion;

public class BinarySearchApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OrdArray ordArray = new OrdArray(10);
		
		ordArray.insert(20);
		ordArray.insert(10);
		ordArray.insert(5);
		ordArray.insert(25);
		ordArray.insert(12);
		ordArray.insert(45);
		ordArray.insert(30);
		
		ordArray.display();
		
		int index = ordArray.find(245);
		System.out.println(" INdex of 245 is "+ index);
	}

}
