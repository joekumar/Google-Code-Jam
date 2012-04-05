package org.learn.dsa.tree;

/*
 * Example taken from http://www.cs.duke.edu/csed/poop/huff/info/
 */
public class HuffmanApp {

	public static void main(String args[]){
		HuffmanEncoder huffmanEncoder = new HuffmanEncoder();
		huffmanEncoder.readAndCreateFrequencyTable("go go gophers");
		huffmanEncoder.printHuffmanCode();
	}
	
}
