package org.learn.dsa.tree;

public class Tree {

	private Node root;

	public Tree() {
		root = new Node();
	}

	public Node getRoot() {
		return root;
	}

	public Node find(int iKey) {
		Node current = root;

		if (current.iData == iKey) {
			System.out.println(" found key " + iKey);
		}

		while (true) {
			if (current == null) {
				return current;
			} else if (current.iData < iKey) {
				current = current.rightChild;
			} else if (current.iData > iKey) {
				current = current.leftChild;
			} else if (current.iData == iKey) {
				return current;
			}

		}
	}

	public void findNPrint(int iKey) {
		Node searchNode = find(iKey);
		if (searchNode == null) {
			System.out.println(" Key " + iKey + " not found ");
		} else {
			System.out.println(" Key found  " + searchNode.iData);
		}
	}

	public void insert(int iKey) {
		Node current = root;
		Node parent;
		parent = current;

		if (root.iData == 0) {
			root.iData = iKey;
			// System.out.println(" Root Key is "+iKey+ " - " + root.iData);
			return;
		}
		while (true) {

			if (current.iData < iKey) {
				parent = current;
				current = current.rightChild;
				if (current == null) {
					current = new Node();
					current.iData = iKey;
					parent.rightChild = current;
					// System.out.println(" Right Key is "+iKey+ " current " +
					// current.iData+" parent " + parent.iData );
					return;
				}
			} else {
				parent = current;
				current = current.leftChild;
				if (current == null) {
					current = new Node();
					current.iData = iKey;
					parent.leftChild = current;
					// System.out.println(" left Key is "+iKey+ " current " +
					// current.iData+" parent " + parent.iData);
					return;
				}
			}
			parent = current;
		}
	}

	public void inOrder(Node curRoot) {

		if (curRoot == null) {
			return;
		}

		inOrder(curRoot.leftChild);
		visit(curRoot);
		inOrder(curRoot.rightChild);
	}

	public int maxValue() {
		Node current = root;
		Node parent = current;
		System.out.println(" current is " + current + " value " + current.iData);

		while (current != null) {
			parent = current;
			current = current.rightChild;
		}

		System.out.println(" Max value = " + parent.iData);
		return parent.iData;
	}

	public int minValue() {
		Node current = root;
		Node parent = current;

		while (current != null) {
			parent = current;
			current = current.leftChild;
		}

		System.out.println(" Min value = " + parent.iData);
		return parent.iData;
	}

	public void visit(Node curRoot) {
		System.out.println(" Node : " + curRoot.iData);
	}

	public boolean isLeaf(Node curNode) {
		if (curNode.leftChild == null && curNode.rightChild == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasOneChild(Node curNode) {
		int intcnt = 0;
		if (curNode.leftChild != null)
			intcnt++;

		if (curNode.rightChild != null)
			intcnt++;

		if (intcnt == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public Node getSuccessor(Node curNode){
		curNode = curNode.rightChild;
		Node parent = curNode;

		while (curNode != null) {
			parent = curNode;
			curNode = curNode.leftChild;
		}
		return parent;
	}
	
	public Node getParent(int iKey){
		Node current = root;
		Node parent = current;

		if (current.iData == iKey) {
			System.out.println(" found key " + iKey);
		}

		while (true) {
			
			if (current == null) {
				return parent;
			} else if (current.iData < iKey) {
				parent = current;
				current = current.rightChild;
			} else if (current.iData > iKey) {
				parent = current;
				current = current.leftChild;
			} else if (current.iData == iKey) {
				return parent;
			}
		}
	}

	public void delete(int iKey) {
		Node current = root;
		Node parent = current;

		if (root.iData == iKey) {
			root = null;
		}

		while (true) {
			if (current.iData < iKey) {
				parent = current;
				current = current.rightChild;

				if (current == null) {
					System.out.println(" Key not found ");
					return;
				}

				if (current.iData == iKey) {
					if (isLeaf(current)) {
						parent.rightChild = null;
						return;
					} else if (hasOneChild(current)) {
						if (current.rightChild != null) {
							parent.rightChild = current.rightChild;
						} else {
							parent.leftChild = current.leftChild;
						}
						return;
					}
					else{
						Node successor = getSuccessor(current);
						System.out.println(" successor is " +successor.iData);
						if(successor.iData == current.rightChild.iData){
							parent.rightChild = successor;
							successor.leftChild = current.leftChild;
							return;
						}
						else{
							Node successorParent = getParent(successor.iData);
							Node tbrParent = getParent(parent.iData);
							successorParent.leftChild = successor.rightChild;
							successor.rightChild = current.rightChild;
							successor.leftChild = current.leftChild;
							tbrParent.rightChild = successor;
						}
					}
				}
			} else {
				parent = current;
				current = current.leftChild;

				if (current == null) {
					System.out.println(" Key not found ");
					return;
				}

				if (current.iData == iKey) {
					if (isLeaf(current)) {
						parent.leftChild = null;
						return;
					} else if (hasOneChild(current)) {
						if (current.rightChild != null) {
							parent.rightChild = current.rightChild;
						} else {
							parent.leftChild = current.leftChild;
						}
						return;
					}
					else{
						Node successor = getSuccessor(current);
						if(successor.iData == current.rightChild.iData){
							parent.rightChild = successor;
							successor.leftChild = current.leftChild;
							return;
						}
					}
				}
			}
		}
	}

}
