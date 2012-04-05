package org.learn.dsa.hashtable;

public class LinearHashTable {

  DataItem hashArray[];
  int arraysize;
  
  public LinearHashTable(int numelements){
    arraysize = numelements * 2;
    hashArray = new DataItem[arraysize];
  }
  
  /*
   * Actual hash function
   */
  public int hashFunction(int key){
    return key % arraysize;
  }

  /*
   * Inserts data item into the array by linear probing
   */
  public void insert(DataItem data){
    int hashVal = hashFunction(data.getData());
    
    while (hashArray[hashVal] != null ){
      hashVal ++;
      if (hashVal == arraysize){
        hashVal = 0;
      }
    }
    hashArray[hashVal] = data;
  }
  
  /*
   * Finds data item into the array by linear probing
   */
  public DataItem find(int key){
    int hashVal = hashFunction(key);
    
    while (hashArray[hashVal] != null ){
      
      if (hashArray[hashVal].getData() == key)
        return hashArray[hashVal];
      
      hashVal ++;
      hashVal %= arraysize;
    }
    return null;
  }
  
  /*
   * Delete data item into the array by linear probing
   */
  public void delete(int key){
    int hashVal = hashFunction(key);
    
    while (hashArray[hashVal] != null ){
      
      if (hashArray[hashVal].getData() == key)
        hashArray[hashVal] = null;
      
      hashVal ++;
      hashVal %= arraysize;
    }
  }
  
  /*
   * Print the Hash Values
   */
  public void printHashTable(){
    for(int i = 0; i < arraysize; i++){
      if (hashArray [i] != null){
        System.out.println(" Value at "+i+ " is "+hashArray[i].getData());
      }
    }
    
  }
}
