package hw03;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to "create a hexagon" and save all the correct information that it needs
 * Other Comments: 
 */
public class Hexagon implements Cloneable{
	// Represents the 6 values in a hexagon, index are as follows: A=0, B=1...F=5
	private char[] colorValues = new char[6];
	private String tileNumber="";

	// Default constructor
	public Hexagon() {
		
	}
	
	// Constructor that gets all values
	public Hexagon(String inputName,char[] inputValues) {
		tileNumber=inputName;
		colorValues=inputValues.clone();
	}
	
	// Constructor to make a copy
	public Hexagon(Hexagon hexToCopy) {
		this.colorValues=hexToCopy.colorValues;
		this.tileNumber=hexToCopy.tileNumber;
	}

	// To "rotate clockwise" hexagon we are just right shifting the array by 1
	public void rotateClockwise() {
		char end = colorValues[colorValues.length - 1];
		for (int i = colorValues.length - 2; i >= 0; i--) {
			colorValues[i + 1] = colorValues[i];
		}
		colorValues[0] = end;

	}
	
	// This method was just created in case I misread the instructions
	public void rotateCounterClockwise() {
		char start = colorValues[0];
		for (int i = 0; i < colorValues.length - 1; i++) {
			colorValues[i] = colorValues[i + 1];
		}
		colorValues[colorValues.length - 1] = start;
	}
	
	// Created to print out info on each line
	public void printTileInfo() {
		System.out.print(tileNumber+": ");
		for(int index=0;index<colorValues.length;index++) {
			System.out.print("\t"+colorValues[index]);
		}
	}
	
	// Method to get a color at specific index
	public char getColorAtIndex(int index) {
		return colorValues[index];
	}
	
	// Method to get the name/number of the tile
	public String getTileNumber() {
		return tileNumber;
	}
	
	public String getColors() {
		String colorValsString = "";
		for(char currentColor:colorValues) {
			colorValsString=colorValsString+currentColor+" ";
		}
		return colorValsString;
	}
	
	public String toString() {
		return tileNumber+": "+getColors();
	}
}
