package com.jp.storeCredit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StoreCredit {
  
  private int credit;
  private int numberOfItemsInStore;
  private String[] ItemPriceArray;
  private List<Item> itemList;
  private int[] result = new int[2];
  private Item[] resultItems = new Item[2];
  private int runningTotal;
  
  public int[] findStoreCredit(String[] dataSet) {
    processDataSet(dataSet);
    calculateStoreCredit();
    sortResultArray();
    return result;
  }
  
  
  
  public void calculateStoreCredit() {
    
    Iterator<Item> itemListIterator = itemList.iterator();
    
    while(itemListIterator.hasNext()){
      Item item = itemListIterator.next();
      int itemPrice = item.getPrice();
      int partnerItemPrice;
      
      if(itemPrice + runningTotal > credit){
        continue;
      }
      
      partnerItemPrice = credit - itemPrice;
      
      if(partnerItemPrice == itemPrice){
        Item potentialPartnerItem = itemListIterator.next();
        if(potentialPartnerItem.getPrice() == partnerItemPrice){
          Item partnerItem = potentialPartnerItem;
          setResultArray(item, partnerItem);
          return;
        }
      }
      
      Item potentialPartnerItem = new Item(-1,partnerItemPrice);
      if (itemList.contains(potentialPartnerItem)){
        Item partnerItem =itemList.get(itemList.indexOf(potentialPartnerItem));
        setResultArray(item, partnerItem);
        return;
      }
    }
    
  }
  
  private void setResultArray(Item item, Item partnerItem){
    result[0] = item.getIndex();
    result[1] = partnerItem.getIndex();
  }
  
  private void sortResultArray(){
    int temp;
    if (result[0] > result[1]){
      temp = result[1];
      result[1] = result[0];
      result[0] = temp;
    }
  }
  
  /*
   * This method will parse the dataset string array and store them in
   * datastructures that would be used for this problem
   */
  private void processDataSet(String[] dataSet) {
    credit = Integer.parseInt(dataSet[0]);
    numberOfItemsInStore = Integer.parseInt(dataSet[1]);
    ItemPriceArray = dataSet[2].split(" ");
    itemList = new ArrayList<Item>();
    
    for (int i = 0; i < ItemPriceArray.length; i++) {
      int price = Integer.parseInt(ItemPriceArray[i]);
      Item item = new Item(i+1, price);
      itemList.add(item);
    }
    
    Collections.sort(itemList);
    
  }
  
}
