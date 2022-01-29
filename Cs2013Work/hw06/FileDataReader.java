package hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to read all data from a file and save to an ArrayList
 * Other Comments: 
 */
public class FileDataReader {
	// this class holds an ArrayList of all data
	private ArrayList<Integer> values=new ArrayList<Integer>();
	
	public FileDataReader(String fileName) {
		readFromFile(fileName);
	}

	private void readFromFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner input = new Scanner(file);
			while (input.hasNextInt()) {
				int data = input.nextInt();
				values.add(data);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Error: %s\n", e);
		}
	}
	
	public ArrayList<Integer> getValues(){
		return values;
	}
}
 
