package org.learn.dsa.hashtable;

public class DoubleHashTable {

  private DataItem[] hashArray;

  private int hashArraySize;

  public DoubleHashTable(int size) {
    hashArraySize = size * 2;
    hashArray = new DataItem[hashArraySize];

  }

  public int getPrime(int size) {
    int prime = size * 2;
    for (int i = 0; i < Math.sqrt(prime); i++) {
      if (prime % i == 0) {
        // prime =
      }
    }
    return prime;
  }

  /*
   * Actual hash function size = 101 key = 25 then hashvalue =
   * 
   */
  public int primaryHashFunction(int key) {
    return key % hashArraySize;
  }

  /*
   * Double hash function - pg 544 Will be used to calculate the step size
   * stepSize = constant - (key % constant);
   */
  public int doubleHashFunction(int key) {
    return 5 - key % 5;
  }

  /*
   * Inserts data item into the array by linear probing
   */
  public void insert(DataItem data) {
    int hashValue = primaryHashFunction(data.getData());
    int stepsize = doubleHashFunction(data.getData());

    while (hashArray[hashValue] != null) {
      hashValue = hashValue + stepsize;
    }

    hashArray[hashValue] = data;
  }

  /*
   * Finds data item into the array by double hashing
   */
  public DataItem find(int key) {
    int hashValue = primaryHashFunction(key);
    int stepsize = doubleHashFunction(key);

    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getData() == key) {
        return hashArray[hashValue];
      }

      hashValue = hashValue + stepsize;
      hashValue = hashValue % hashArraySize;
    }
    return null;
  }

  /*
   * Delete data item from hashArray
   */
  public void delete(int key) {
    int hashValue = primaryHashFunction(key);
    int stepsize = doubleHashFunction(key);

    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getData() == key) {
        hashArray[hashValue] = null;
        return;
      }

      hashValue = hashValue + stepsize;
      hashValue = hashValue % hashArraySize;
    }
    System.out.println(" Item " + key + " Not Found. So cannot delete... ");
    return;
  }

  /*
   * Print the Hash Values
   */
  public void printHashTable() {
    for (int i = 0; i < hashArraySize; i++) {
      if (hashArray[i] != null) {
        System.out.println(" Value at " + i + " is " + hashArray[i].getData());
      }
    }

  }
}
