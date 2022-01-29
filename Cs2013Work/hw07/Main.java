package hw07;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to test the BinarySearchTree class
 * Other Comments: 
 */

public class Main {
	
	public static void main(String[] args) throws DuplicateItemException {
		System.out.println(
				"---------------------Demonstration of the insert method (note: this is replicating video 05 in week 12)-------------------------------");
		BinarySearchTree bstInsert = new BinarySearchTree();
		System.out.println("Original Binary Search tree with values: ");
		System.out.println(bstInsert.toString()+"\n");

		bstInsert.insert(8);
		bstInsert.insert(4);
		bstInsert.insert(12);
		bstInsert.insert(1);
		bstInsert.insert(5);
		bstInsert.insert(9);
		bstInsert.insert(15);
		bstInsert.insert(3);
		bstInsert.insert(6);
		bstInsert.insert(10);
		bstInsert.insert(14);
		bstInsert.insert(2);
		bstInsert.insert(7);
		bstInsert.insert(11);
		bstInsert.insert(13);
		System.out.println("Binary Search tree after inserting values 8,4,12,1,5,9,15,3,6,10,14,2,7,11,13: ");
		System.out.println(bstInsert.toString());

		System.out.println("---------------------Demonstration of the delete method (note: this is replicating video 06 in week 12)-------------------------------");
		BinarySearchTree bstDelete=new BinarySearchTree(25,20,36,10,22,30,40,5,12,28,38,48,1,8,15,45,50);
		System.out.println("Original Binary Search tree with values: ");
		System.out.println(bstDelete.toString());
		
		bstDelete.delete(1);
        bstDelete.delete(50);
        bstDelete.delete(30);
        bstDelete.delete(48);
        bstDelete.delete(25);
        bstDelete.delete(12);
        bstDelete.delete(10);
        System.out.println("Binary Search tree after deleting values 1,50,30,48,25,10,8: ");
        System.out.println(bstDelete.toString());
		
		System.out.println(
				"---------------------Demonstration of the find method (using insert() example binary search tree)-------------------------------");
		System.out.println("Does the value 123 exist: "+bstInsert.find(123));
		System.out.println("Does the value 15 exist: "+bstInsert.find(15)+"\n");
		System.out.println(
				"---------------------Demonstration of the isEmpty method (using insert() example bst and empty bst)-------------------------------");
		BinarySearchTree bstEmpty = new BinarySearchTree();
		System.out.println("Is the bstInsert bst empty?: "+bstInsert.isEmpty());
		System.out.println("Is the bstEmpty empty?: "+bstEmpty.isEmpty()+"\n");
		System.out.println(
				"---------------------Demonstration of the preorder method (using insert() example bst)-------------------------------");
		System.out.println(bstInsert.preorder().toString()+"\n");
		System.out.println(
				"---------------------Demonstration of the inorder method (using insert() example bst)-------------------------------");
		System.out.println(bstInsert.inorder().toString()+"\n");
		System.out.println(
				"---------------------Demonstration of the postorder method (using insert() example bst)-------------------------------");
		System.out.println(bstInsert.postorder().toString()+"\n");
		System.out.println(
				"---------------------Demonstration of the breadthfirst method (using insert() example bst)-------------------------------");
		System.out.println(bstInsert.breadthfirst().toString()+"\n");
		
		System.out.println("---------------------Testing with a heavily right skewed binary search tree-------------------------------");
		BinarySearchTree bstSkewed=new BinarySearchTree(10,4,12,11,300,150,400,350,600,500,700,650,750);
		System.out.println("Original Binary Search tree with values: ");
		System.out.println(bstSkewed.toString());
		System.out.println("breadth first values: "+bstSkewed.breadthfirst().toString());
		System.out.println("post order values: "+bstSkewed.postorder().toString());
		System.out.println("in order values: "+bstSkewed.inorder().toString());
		System.out.println("pre order values: "+bstSkewed.preorder().toString());
		
	}
}
