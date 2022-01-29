package hw05;

import java.util.Random;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be a test for the 2D array/linkedlist that was created
 * Other Comments: Note: All Array2D demos were printed row by row.
 * Also, for the set() method I was trying to input 0217 as a value at a valid index and 
 * it didn't work, however, the method worked with any other value I typed in, why is that? 
 */

public class Main {
	public static void main(String[] args) {
		// create an instance of the Random class to generate random ints
		Random rand = new Random();

		System.out.println("\t\t-------------------Array2d with Integers------------------");
		// 2d array to be passed to test one constructor
		Object[][] myArr = new Object[10][5];

		// fill in the 2d array with random numbers
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[0].length; j++) {
				// the ints only go up to 100
				int randNum = rand.nextInt(100);
				// set current Node to randNum
				myArr[i][j] = randNum;
			}
		}
		// test the Array2D(E[][]) constructor
		Array2D<Integer> ad = new Array2D(myArr);
		System.out.println("\tOriginal Array2D"); // print original Array2D
		ad.printRowByRow();
		System.out.println("\tArray2D after using addFirstCol() method"); // addFirstCol() demo
		ad.addFirstCol();
		ad.printRowByRow();
		System.out.println("\tArray2D after using addFirstRow() method"); // addFirstRow() demo
		ad.addFirstRow();
		ad.printRowByRow();
		System.out.println("\tArray2D after using addLastCol() method"); // addLastCol() demo
		ad.addLastCol();
		ad.printRowByRow();
		System.out.println("\tArray2D after using addLastRow() method"); // addLastRow() demo
		ad.addLastRow();
		ad.printRowByRow();
		System.out.println("\tArray2D after using insertCol(index) method at index 3"); // insertCol() demo
		ad.insertCol(3);
		ad.printRowByRow();
		System.out.println("\tArray2D after using insertRow(index) method at index 6"); // insertRow() demo
		ad.insertRow(6);
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteFirstCol()"); // deleteFirstCol() demo
		ad.deleteFirstCol();
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteLastCol()"); // deleteLastCol() demo
		ad.deleteLastCol();
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteFirstRow()"); // deleteFirstRow() demo
		ad.deleteFirstRow();
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteLastRow()"); // deleteLastRow() demo
		ad.deleteLastRow();
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteCol(index) at index 2"); // deleteCol() demo
		ad.deleteCol(2);
		ad.printRowByRow();
		System.out.println("\tArray2D after using deleteRow(index) at index 5"); // deleteRow() demo
		ad.deleteRow(5);
		ad.printRowByRow();
		System.out.println("Value at row 4, col 2: " + ad.get(4, 2)); // get() demo
		System.out.println("Values in column 3: " + ad.getCol(3)); // getCol() demo
		System.out.println("Values in row 6: " + ad.getRow(6)); // getRow() demo
		System.out.println("\tArray2D after inputing \"1111\" using set(row,col,item) at row 5, column 2"); // set()
																											// demo
		ad.set(5, 2, 1111);
		ad.printRowByRow();

		System.out.println("\t\t-------------------Array2d with Strings------------------");
		Array2D<String> bc = new Array2D();
		System.out.println("\tOriginal Array2D"); // print original Array2D
		bc.printRowByRow();
		System.out.println("\tArray2D after using addFirstCol() method 3x"); // addFirstCol() demo
		for (int i = 1; i <= 3; i++) {
			bc.addFirstCol();
		}
		bc.printRowByRow();
		System.out.println("\tArray2D after using addFirstRow() method 3x"); // addFirstRow() demo
		for (int i = 1; i <= 3; i++) {
			bc.addFirstRow();
		}
		bc.printRowByRow();
		System.out.println("\tArray2D after using addLastCol() method"); // addLastCol() demo
		bc.addLastCol();
		bc.printRowByRow();
		System.out.println("\tArray2D after using addLastRow() method"); // addLastRow() demo
		bc.addLastRow();
		bc.printRowByRow();
		System.out.println("\tArray2D after using insertCol(index) method at index 1"); // insertCol() demo
		bc.insertCol(1);
		bc.printRowByRow();
		System.out.println("\tArray2D after using insertRow(index) method at index 2"); // insertRow() demo
		bc.insertRow(2);
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteFirstCol()"); // deleteFirstCol() demo
		bc.deleteFirstCol();
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteLastCol()"); // deleteLastCol() demo
		bc.deleteLastCol();
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteFirstRow()"); // deleteFirstRow() demo
		bc.deleteFirstRow();
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteLastRow()"); // deleteLastRow() demo
		bc.deleteLastRow();
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteCol(index) at index 2"); // deleteCol() demo
		bc.deleteCol(2);
		bc.printRowByRow();
		System.out.println("\tArray2D after using deleteRow(index) at index 5"); // deleteRow() demo
		bc.deleteRow(3);
		bc.printRowByRow();
		System.out.println("Value at row 1, col 1: " + bc.get(1, 1)); // get() demo
		System.out.println("Values in column 1: " + bc.getCol(1)); // getCol() demo
		System.out.println("Values in row 0: " + bc.getRow(0)); // getRow() demo
		System.out.println("\tArray2D after inputing \"Hello\" using set(row,col,item) at all nodes"); // set() demo
		for (int i = 0; i < bc.rowSize(); i++) {
			for (int j = 0; j < bc.colSize(); j++) {
				bc.set(i, j, "Hello");
			}
		}
		bc.printRowByRowStrings();

		System.out.println("\t\t-------------------Array2d with Doubles------------------");
		Array2D<Double> ef = new Array2D(5, 5);
		System.out.println("\tOriginal Array2D"); // print original Array2D
		ef.printRowByRow();
		System.out.println("\tArray2D after inputing random doubles using set(row,col,item) at all nodes"); // set() demo
		for (int i = 0; i < ef.rowSize(); i++) {
			for (int j = 0; j < ef.colSize(); j++) {
				double newDoubleValue = Math.round((rand.nextDouble() * 5) * 100.0) / 100.0;
				ef.set(i, j, newDoubleValue);
			}
		}
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using addFirstCol() method 3x"); // addFirstCol() demo
		ef.addFirstCol();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using addFirstRow() method 3x"); // addFirstRow() demo
		ef.addFirstRow();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using addLastCol() method"); // addLastCol() demo
		ef.addLastCol();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using addLastRow() method"); // addLastRow() demo
		ef.addLastRow();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using insertCol(index) method at index 1"); // insertCol() demo
		ef.insertCol(1);
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using insertRow(index) method at index 2"); // insertRow() demo
		ef.insertRow(2);
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteFirstCol()"); // deleteFirstCol() demo
		ef.deleteFirstCol();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteLastCol()"); // deleteLastCol() demo
		ef.deleteLastCol();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteFirstRow()"); // deleteFirstRow() demo
		ef.deleteFirstRow();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteLastRow()"); // deleteLastRow() demo
		ef.deleteLastRow();
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteCol(index) at index 2"); // deleteCol() demo
		ef.deleteCol(2);
		ef.printRowByRowStrings();
		System.out.println("\tArray2D after using deleteRow(index) at index 5"); // deleteRow() demo
		ef.deleteRow(3);
		ef.printRowByRowStrings();
		System.out.println("Value at row 1, col 1: " + ef.get(1, 1)); // get() demo
		System.out.println("Values in column 1: " + ef.getCol(1)); // getCol() demo
		System.out.println("Values in row 0: " + ef.getRow(0)); // getRow() demo

	}
}
