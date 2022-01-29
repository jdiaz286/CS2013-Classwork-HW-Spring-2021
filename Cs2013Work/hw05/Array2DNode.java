package hw05;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be a Node that will be used in Array2D
 * Other Comments: 
 */

public class Array2DNode<E> {
	private E item;
	protected Array2DNode<E> nextCol;
	protected Array2DNode<E> nextRow;
	
	// Default Constructor
	public Array2DNode() {
		
	}
	
	public Array2DNode(E item) {
		this.item=item;
	}
	
	public E getItem() {
		return item;
	}
	
	public void setItem(E value) {
		item=value;
	}
}
