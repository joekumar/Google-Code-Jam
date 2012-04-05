package org.learn.dsa.recursion;

public class AnagramApp {

	static int size;
	static int count;
	static char[] arrChar = new char[100];
	
	public static void main(String[] args) {
		String strInput = "cats";
		size = strInput.length();
		count = 0;
		
		for(int i = 0; i < size; i++){
			arrChar[i] = strInput.charAt(i);
		}
		
		doAnagram(size);
	}
	
	public static void doAnagram(int intVal){
		// basecase
		if(intVal == 1){
			return;
		}
		
		for(int i = 0; i < intVal; i++){
			doAnagram(intVal - 1);
			
			if (intVal == 2){
				displayWord();
			}
			rotate(intVal);
		}
	}

	// rotate left all chars from current position to end
	public static void rotate(int newsize){
		int newLoopIndex = size - newsize;
		char firstElement = arrChar[newLoopIndex];
		int j;
		
		for (j = newLoopIndex +1; j < size; j++){
			//System.out.println(" j-1 val "+ arrChar[j-1] + " j val "+arrChar[j]);
			arrChar[j-1] = arrChar[j];
			//System.out.println(" j-1 val "+ arrChar[j-1] + " j val "+arrChar[j]);
		}
		
		arrChar[j-1] = firstElement;
	}
	
	public static void displayWord(){
		System.out.print(++count+" "); // just a counter for the number of words
		for(int i = 0; i < size; i++){
			System.out.print(arrChar[i]);
		}
		System.out.print("\t");
		
		if (count%6 == 0) // wrap for every 6th word
			System.out.print("\n");
	}
}
