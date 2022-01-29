package hw03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to get all the data from the file that the user input and save it to the correct file
 * Other Comments: 
 */
public class FileReader {
	private char[] tileOneColors = new char[6];
	private char[] tileTwoColors = new char[6];
	private char[] tileThreeColors = new char[6];
	private char[] tileFourColors = new char[6];
	private char[] tileFiveColors = new char[6];
	private char[] tileSixColors = new char[6];
	private char[] tileSevenColors = new char[6];
	private String tileOneName = "";
	private String tileTwoName = "";
	private String tileThreeName = "";
	private String tileFourName = "";
	private String tileFiveName = "";
	private String tileSixName = "";
	private String tileSevenName = "";

	public FileReader(String in) {
		readFromFile(in);
	}

	// This method reads from the file and saves all data in the correct variable
	public void readFromFile(String in) {
		File file = new File(in);
		try {
			Scanner input = new Scanner(file);

			// Get all the lines and save data as String
			String firstLine = input.nextLine();
			String secondLine = input.nextLine();
			String thirdLine = input.nextLine();
			String fourthLine = input.nextLine();
			String fifthLine = input.nextLine();
			String sixthLine = input.nextLine();
			String seventhLine = input.nextLine();

			// This section gets and saves all colors for first tile
			String[] firstLineDivider = firstLine.split(": ");
			tileOneName = firstLineDivider[0];
			char[] tileOneHolder = firstLineDivider[1].toCharArray(); // Get the colors and save as array of char
			int tileColorIndex = 0;
			for (int i = 0; i < tileOneHolder.length; i++) { // Save only color values and not commas
				if (tileOneHolder[i] == ',') {
					continue;
				} else if (tileOneHolder[i] != ',') {
					tileOneColors[tileColorIndex] = tileOneHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for second tile
			String[] secondLineDivider = secondLine.split(": ");
			tileTwoName = secondLineDivider[0];
			char[] tileTwoHolder = secondLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileTwoHolder.length; i++) { // Save only color values and not commas
				if (tileTwoHolder[i] == ',') {
					continue;
				} else if (tileTwoHolder[i] != ',') {
					tileTwoColors[tileColorIndex] = tileTwoHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for third tile
			String[] thirdLineDivider = thirdLine.split(": ");
			tileThreeName = thirdLineDivider[0];
			char[] tileThreeHolder = thirdLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileThreeHolder.length; i++) { // Save only color values and not commas
				if (tileThreeHolder[i] == ',') {
					continue;
				} else if (tileThreeHolder[i] != ',') {
					tileThreeColors[tileColorIndex] = tileThreeHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for fourth tile
			String[] fourthLineDivider = fourthLine.split(": ");
			tileFourName = fourthLineDivider[0];
			char[] tileFourHolder = fourthLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileFourHolder.length; i++) { // Save only color values and not commas
				if (tileFourHolder[i] == ',') {
					continue;
				} else if (tileFourHolder[i] != ',') {
					tileFourColors[tileColorIndex] = tileFourHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for fifth tile
			String[] fifthLineDivider = fifthLine.split(": ");
			tileFiveName = fifthLineDivider[0];
			char[] tileFiveHolder = fifthLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileFiveHolder.length; i++) { // Save only color values and not commas
				if (tileFiveHolder[i] == ',') {
					continue;
				} else if (tileFiveHolder[i] != ',') {
					tileFiveColors[tileColorIndex] = tileFiveHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for sixth tile
			String[] sixthLineDivider = sixthLine.split(": ");
			tileSixName = sixthLineDivider[0];
			char[] tileSixHolder = sixthLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileSixHolder.length; i++) { // Save only color values and not commas
				if (tileSixHolder[i] == ',') {
					continue;
				} else if (tileSixHolder[i] != ',') {
					tileSixColors[tileColorIndex] = tileSixHolder[i];
					tileColorIndex++;
				}
			}

			// This section gets and saves all colors for seventh tile
			String[] seventhLineDivider = seventhLine.split(": ");
			tileSevenName = seventhLineDivider[0];
			char[] tileSevenHolder = seventhLineDivider[1].toCharArray(); // Get the colors and save as array of char
			tileColorIndex = 0;
			for (int i = 0; i < tileSevenHolder.length; i++) { // Save only color values and not commas
				if (tileSevenHolder[i] == ',') {
					continue;
				} else if (tileSevenHolder[i] != ',') {
					tileSevenColors[tileColorIndex] = tileSevenHolder[i];
					tileColorIndex++;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.printf("Error: %s\n", e);
		}
	}

	
	// Getters
	public char[] getTileOneColors() {
		return tileOneColors;
	}

	public char[] getTileTwoColors() {
		return tileTwoColors;
	}

	public char[] getTileThreeColors() {
		return tileThreeColors;
	}

	public char[] getTileFourColors() {
		return tileFourColors;
	}

	public char[] getTileFiveColors() {
		return tileFiveColors;
	}

	public char[] getTileSixColors() {
		return tileSixColors;
	}

	public char[] getTileSevenColors() {
		return tileSevenColors;
	}

	public String getTileOneName() {
		return tileOneName;
	}

	public String getTileTwoName() {
		return tileTwoName;
	}

	public String getTileThreeName() {
		return tileThreeName;
	}

	public String getTileFourName() {
		return tileFourName;
	}

	public String getTileFiveName() {
		return tileFiveName;
	}

	public String getTileSixName() {
		return tileSixName;
	}

	public String getTileSevenName() {
		return tileSevenName;
	}

}
