package hw07;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to create a Binary search tree
 * Other Comments: 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root;

	// default constructor, does nothing
	public BinarySearchTree() {
		root=null;
	}

	// adds a list of values to a binary search tree
	public BinarySearchTree(E... list) throws DuplicateItemException {
		// go through each of the values in the list and add
		for (int i = 0; i < list.length; i++) {
			E value = list[i];
			insert(value);
		}
	}

	// insert non duplicate value to binary search tree
	public void insert(E value) throws DuplicateItemException {
		// save new value to node child
		BSTNode<E> child = new BSTNode(value);

		// check to see if the bst is empty
		if (this.isEmpty()) {
			// set root to child
			this.root = child;
			// if not empty
		} else {
			try {
				// find the point which child would be connected to
				child.parent = insertionPoint(value);
				// if value less than parent value
				if (value.compareTo(child.parent.data) < 0) {
					// set the parent left side to child
					child.parent.left = child;
				}
				// if value greater than parent value
				else if (value.compareTo(child.parent.data) > 0) {
					// set the parent right side to child
					child.parent.right = child;
				}
				// catch if there are any duplicate values
			} catch (DuplicateItemException ex) {
				throw ex;
			}
		}
	}

	// method to delete a value from bst
	public void delete(E value) {
		// find the node to delete and delete(node)
		delete(nodeToDelete(value));
	}

	// method to delete a node and "connect" remaining nodes
	private void delete(BSTNode<E> node) {
		if (node != null) {
			// check if the node has no right and left nodes
			if (isLeaf(node)) {
				// if the node is a left child
				if (isLeftChild(node)) {
					// set the parent nodes' left node to null
					node.parent.left = null;
				}
				// if the node is a right child
				else if (isRightChild(node)) {
					// set the parent nodes' right node to null
					node.parent.right = null;
				}
			}

			// if the node to delete has one child
			else if (numChildren(node) == 1) {
				// get the left or right child of node, non null node
				BSTNode<E> child = node.left;
				if (node.right != null) {
					child = node.right;
				}
				// if left is not null, set left side of parent node to child
				if (isLeftChild(node)) {
					node.parent.left = child;
				}
				// if right is not null, set right side of parent node to child
				else if (isRightChild(node)) {
					node.parent.right = child;
				}
			}
			// if the node to delete has two children
			else if (numChildren(node) == 2) {
				// find the max on the left subtree and save
				BSTNode<E> max = maxLeftSubtree(node);
				// set node equal to the item of max
				node.setItem(max.getItem());
				// recursively delete max
				delete(max);
			}
		}
	}

	// method to find if a value exists in a bst
	public boolean find(E value) {
		// save an reference of the root to track node
		BSTNode<E> current = root;
		while (current != null) {
			// if the value == current.data return true
			if (value.equals(current.data)) {
				return true;
			}
			// if value less than current value
			else if (value.compareTo(current.data) < 0) {
				// set current to the left side of current
				current = current.left;
			}
			// if value greater than current value
			else if (value.compareTo(current.data) > 0) {
				// set current to the right side of current
				current = current.right;
			}
		}
		return false;
	}

	// check to see if the binary search tree is empty (root is null)
	public boolean isEmpty() {
		return (this.root == null);
	}

	// method that returns list of preorder of bst
	public ArrayList<E> preorder() {
		// create arraylist to store values
		ArrayList<E> vals = new ArrayList<E>();
		// recursively add vals to list starting at root
		preorder(root, vals);
		// return the list of values
		return vals;
	}

	// recursive method that continues to add value in preorder
	private void preorder(BSTNode<E> node, ArrayList<E> vals) {
		// if node is null then return
		if (node == null) {
			return;
		}
		// visit value by adding node item to vals
		vals.add(node.getItem());
		// recursively go to the left side of node
		preorder(node.left, vals);
		// recursively go to the right side of node
		preorder(node.right, vals);
	}

	// method that returns list of inorder of bst
	public ArrayList<E> inorder() {
		// create arraylist to store values
		ArrayList<E> vals = new ArrayList<E>();
		// recursively add vals to list starting at root
		inorder(root, vals);
		// return the list of values
		return vals;
	}

	// recursive method that continues to add value in inorder
	private void inorder(BSTNode<E> node, ArrayList<E> vals) {
		// if node is null then return
		if (node == null) {
			return;
		}
		// recursively go to the left side of node
		inorder(node.left, vals);
		// visit value by adding node item to vals
		vals.add(node.getItem());
		// recursively go to the right side of node
		inorder(node.right, vals);
	}

	// method that returns list of postorder of bst
	public ArrayList<E> postorder() {
		// create arraylist to store values
		ArrayList<E> vals = new ArrayList<E>();
		// recursively add vals to list starting at root
		postorder(root, vals);
		// return the list of values
		return vals;
	}

	// recursive method that continues to add value in postorder
	private void postorder(BSTNode<E> node, ArrayList<E> vals) {
		// if node is null then return
		if (node == null) {
			return;
		}
		// recursively go to the left side of node
		postorder(node.left, vals);
		// recursively go to the right side of node
		postorder(node.right, vals);
		// visit value by adding node item to vals
		vals.add(node.getItem());
	}

	public ArrayList<E> breadthfirst() {
		// create arraylist to store values
		ArrayList<E> vals = new ArrayList<E>();
		// recursively add vals to list starting at root
		breadthfirst(root, vals);
		// return the list of values
		return vals;
	}

	// method that returns list of breadth-first of bst
	public ArrayList<E> breadthfirst(BSTNode<E> root, ArrayList<E> vals) {
		// create a queue
		Queue<BSTNode<E>> q = new LinkedList<>();
		// add root to queue
		q.add(root);
		// while the queue is not empty
		while (!q.isEmpty()) {
			// get the first node in queue
			BSTNode<E> node = q.remove();
			// save the item of the node to the list
			if (node != null) {
				vals.add(node.getItem());
				// add the left and right nodes to queue
				q.add(node.left);
				q.add(node.right);
			}

		}
		return vals;
	}

	// method that returns the values of bst as string
	@Override
	public String toString() {
		return returnTree();
	}

	// checks if node is leaf (right and left are null)
	private boolean isLeaf(BSTNode<E> node) {
		return node.left == null && node.right == null;
	}

	// check if node is left Child
	private boolean isLeftChild(BSTNode<E> node) {
		// check to make sure node and root are not the same
		if(node.data.compareTo(this.root.data) != 0) {
			// make sure the left node of parent node is not null
			if(node.parent.left != null) {
				if(node.parent.left.data.compareTo(node.data) == 0) {
					return true;
				}
			}
		}
		
		return false;
	}

	// check if node is right Child
	private boolean isRightChild(BSTNode<E> node) {
		// check to make sure node and root are not the same
		if(node.data.compareTo(this.root.data) != 0) {
			// make sure the right node of parent node is not null
			if(node.parent.right != null) {
				// check if parent and node's data are the same
				if(node.parent.right.data.compareTo(node.data) == 0) {
					return true;
				}
			}
		}
		
		return false;
	}

	// returns how many children a node has
	private int numChildren(BSTNode<E> node) {
		int count = 0;
		// add 1 if left node is not empty
		if (node.left != null) {
			count++;
		}

		// add 1 if right node is not empty
		if (node.right != null) {
			count++;
		}
		return count;
	}

	// A helper method for insert() that helps find parent node of desired value
	private BSTNode<E> insertionPoint(E value) throws DuplicateItemException {
		// instantiate reference nodes
		BSTNode<E> current = root; // this will be our reference hoper node
		BSTNode<E> parent = null; // node to be returned

		// loop until you reach an empty node
		while (current != null) {
			// if the value is repeated, return exception
			if (value == current.data) {
				// states what value is repeated
				throw new DuplicateItemException("Value \"" + value + "\" is a duplicate value.");
				// if value is less than current data, set current to left side
			} else if (value.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
				// if value is less than current data, set current to right side
			} else if (value.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			}
		}
		// return node before current value
		return parent;
	}

	// method to find the node that will be deleted
	private BSTNode<E> nodeToDelete(E value) {
		// save a reference node to traverse
		BSTNode<E> current = this.root;
		// loop till we find the correct node
		while (current != null) {
			// if data = value, save return current node
			if (value.equals(current.data)) {
				return current;
				// if the value is less than data, traverse to the left
			} else if (value.compareTo(current.data) < 0) {
				current = current.left;
				// if the value is greater than data, traverse to the right
			} else if (value.compareTo(current.data) > 0) {
				current = current.right;
			}
		}
		// if nothing is found, return nothing
		return null;
	}

	// Method to find max value in left subtree
	private BSTNode<E> maxLeftSubtree(BSTNode<E> node) {
		BSTNode<E> current = node.left;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	// credit for original non modified algorithm goes to https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	// helper methods to help return a string of the bst
	private String returnTree() {
		String bstString="";
		if(this.isEmpty()) {
			bstString="Tree is empty.\t";
		}
		else {
			if (this.root.right != null) {
				bstString += this.returnTree(this.root.right, true, "");
			}

			bstString += returnNodeValue(this.root);

			if (this.root.left != null) {
				bstString += this.returnTree(this.root.left, false, "");
			}
		}
		return bstString;
	}

	private String returnTree(BSTNode<E> node, boolean isRight, String indent) {
		String bstString="";
		if (node.right != null) {
			bstString+=returnTree(node.right, true, indent + (isRight ? "        " : " |      "));
		}

		bstString+=indent;

		if (isRight) {
			bstString+=" /";
		} else {
			bstString+=" \\";
		}
		bstString+="----- ";
		bstString+=returnNodeValue(node);
		if (node.left != null) {
			bstString+=returnTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
		return bstString;
	}

	private String returnNodeValue(BSTNode<E> node) {
		String bstString="";
		if (node == null) {
			bstString+="<null>";
		} else {
			bstString+=node.getItem();
		}
		bstString+="\n";
		return bstString;
	}
}
