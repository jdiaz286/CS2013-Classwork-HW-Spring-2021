package hw07;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be a Node that will be used in the BinarySearchTree class
 * Other Comments: 
 */
public class BSTNode<E extends Comparable<E>> {
	protected BSTNode<E> parent;
	protected BSTNode<E> left;
	protected BSTNode<E> right;
	protected E data;
	
	public BSTNode(E inputVal) {
		data=inputVal;
	}
	
	//getters and setters
	public void setItem(E item) {
		data=item;
	}
	
	public E getItem() {
		return data;
	}
}
