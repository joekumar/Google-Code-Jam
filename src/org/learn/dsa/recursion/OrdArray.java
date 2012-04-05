package org.learn.dsa.recursion;

public class OrdArray {

	private long[] arr;
	private int nElements;
	
	public OrdArray(int n){
		arr = new long [n];
		nElements = 0;
	}
	
	public int size(){
		return nElements;
	}
	
	public void insert (long key){
		int j;
		
		for (j = 0; j < nElements; j++){
			if (arr[j] > key) 
				break;
		}
		for( int k = nElements+1; k > j; k--){
			arr[k] = arr[ k -1];
		}
		arr[j] = key;
		nElements ++;
	}
	
	/*
	 * IMplement binary search using loop
	 * 
	 */
	public int find (long searchKey){
		int lowerbound = 0;
		int upperbound = nElements -1;
		int currentIndex;
		
		while (true){
			currentIndex = (upperbound + lowerbound) / 2 ;
			
			if (lowerbound > upperbound){
				return -1;
			}
			
			if (searchKey == (arr[upperbound] + arr[lowerbound])/2){
				return currentIndex;
			}
			else if (searchKey > (arr[upperbound] + arr[lowerbound])/2) {
				lowerbound = currentIndex + 1;
			}
			else if (searchKey < (arr[upperbound] + arr[lowerbound])/2) {
				upperbound = currentIndex - 1;
			}
		}
		
		
	}
	
	public void display(){
		for (int i = 0; i < nElements; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.print("\n");
	}
	
}
