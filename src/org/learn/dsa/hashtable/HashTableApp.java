package org.learn.dsa.hashtable;

public class HashTableApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    LinearHashTable linearHmTable = new LinearHashTable(3);
    DataItem d1 = new DataItem(2);
    DataItem d2 = new DataItem(6);
    DataItem d3 = new DataItem(7);
    DataItem d4 = new DataItem(8);
    DataItem d5 = new DataItem(9343);
   /* linearHmTable.insert(d1);
    linearHmTable.insert(d2);
    linearHmTable.insert(d3);
    linearHmTable.insert(d4);
    linearHmTable.insert(d5);
    linearHmTable.printHashTable();
    System.out.println(" Found element at "+linearHmTable.find(98));
    */
    linearHmTable.delete(73);
    //linearHmTable.printHashTable();
    
    DoubleHashTable doubleHmTable = new DoubleHashTable(3);
    doubleHmTable.insert(d1);
    doubleHmTable.insert(d2);
    doubleHmTable.insert(d3);
    doubleHmTable.insert(d4);
    doubleHmTable.insert(d5);
    doubleHmTable.printHashTable();
    System.out.println(" Found element at "+doubleHmTable.find(9343).getData());
    doubleHmTable.delete(73);
    doubleHmTable.printHashTable();
    
  }

}
