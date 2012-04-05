package org.learn.dsa.tree;

import java.util.Comparator;

public class HuffmanTreeComparator implements Comparator<HuffmanNode> {

	public int compare(HuffmanNode ht1, HuffmanNode ht2) {
		int ht1cost = ht1.frequency;
		int ht2cost = ht2.frequency;
System.out.println(" comparing freq "+ht1cost +" against "+ht2cost);
		if (ht1cost > ht2cost)
			return -1;
		else if (ht1cost < ht2cost)
			return 1;
		else {
				if (ht1.character != ht2.character)
					return -1;
				else
					return 0;
			}
	}

}
