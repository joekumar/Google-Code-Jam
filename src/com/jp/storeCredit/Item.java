package com.jp.storeCredit;

public class Item implements Comparable<Item> {
  
  
  private int index;
  private int price;
  
  
  public Item(int index, int price){
    this.index = index;
    this.price = price;
  }
  
  /** {@inheritDoc}*/
  @Override
  public int compareTo(Item arg0) {
    if(this.price > arg0.price){
      return 1;
    }
    else if (this.price < arg0.price){
      return -1;
    }
    return 0;
  }
  
  /** {@inheritDoc}*/
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + index;
    result = prime * result + price;
    return result;
  }
  
  /** {@inheritDoc}*/
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Item other = (Item) obj;
    if (price != other.price) return false;
    return true;
  }
  
  
  
  /** * @return Returns the index.
   */
  public int getIndex() {
    return index;
  }
  /**
   * @param index The index to set.
   */
  public void setIndex(int index) {
    this.index = index;
  }
  /** * @return Returns the price.
   */
  public int getPrice() {
    return price;
  }
  /**
   * @param price The price to set.
   */
  public void setPrice(int price) {
    this.price = price;
  }
  
  
  
}
