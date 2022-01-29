package hw03;

import java.util.Scanner;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to find all the solutions
 * Other Comments: 
 */
public class SolutionFinder {
	private static int numSolution = 0;

	// This method gets the user file input and saves each hexagon
	public void getSolutions() {
		Scanner input = new Scanner(System.in);
		System.out.print("Type in the name of the file with Hexagons: ");
		String fileInput = input.nextLine();
		FileReader fileData = new FileReader(fileInput);
		// Create seven Hexagons and send the correct data to each one
		Hexagon tileOne = new Hexagon(fileData.getTileOneName(), fileData.getTileOneColors());
		Hexagon tileTwo = new Hexagon(fileData.getTileTwoName(), fileData.getTileTwoColors());
		Hexagon tileThree = new Hexagon(fileData.getTileThreeName(), fileData.getTileThreeColors());
		Hexagon tileFour = new Hexagon(fileData.getTileFourName(), fileData.getTileFourColors());
		Hexagon tileFive = new Hexagon(fileData.getTileFiveName(), fileData.getTileFiveColors());
		Hexagon tileSix = new Hexagon(fileData.getTileSixName(), fileData.getTileSixColors());
		Hexagon tileSeven = new Hexagon(fileData.getTileSevenName(), fileData.getTileSevenColors());
		// Save all the hexagons in a "place holder"
		Hexagon[] hexagonHolder = { tileOne, tileTwo, tileThree, tileFour, tileFive, tileSix, tileSeven };
		solve(hexagonHolder);

	}

	public void solve(Hexagon[] hexagonHolder) {
		int currentHexIndex = 0;
		// The empty array will hold the solution
		Hexagon[] solutionHolder = new Hexagon[7];
		solve(hexagonHolder, currentHexIndex, solutionHolder);
		if (numSolution == 0) {
			System.out.println("No solutions found in tile set");
		}
	}

	// Recursive method
	private void solve(Hexagon[] hexagonHolder, int solutionHolderIndex, Hexagon[] solutionHolder) {
		Hexagon[] hexHolderCopy = new Hexagon[hexagonHolder.length];
		System.arraycopy(hexagonHolder, 0, hexHolderCopy, 0, hexagonHolder.length);

		// Base Case
		if (positionSevenValid(solutionHolder)) {
			printFormat(solutionHolder);
		} else {// Recursive case
			// Control which hexagon you are on
			for (int currentHex = 0; currentHex < 7; currentHex++) {
				// Control how many rotations there are, there should be 6
				for (int currentRotation = 1; currentRotation <= 6; currentRotation++) {

					// make sure to not rotate the center tile
					if (solutionHolderIndex != 0) {
						hexHolderCopy[currentHex].rotateClockwise();
					}

					if (canBePlaced(solutionHolder, solutionHolderIndex, hexHolderCopy[currentHex])) {
						// place hexagon
						solutionHolder[solutionHolderIndex] = hexHolderCopy[currentHex];
						// recurse to next hexagon by finding next index of solution holder
						solve(hexagonHolder, solutionHolderIndex + 1, solutionHolder);
						// backtrack by leaving the index blank
						solutionHolder[solutionHolderIndex] = null;
					}

				}
			}
		}

	}

	// This method just helps make getSolutions() more presentable
	public void printFormat(Hexagon[] solutionOrder) {
		numSolution++;
		System.out.println("Solution #" + numSolution + "---------------------------------------------------------");
		System.out.println("\t\t\tSA\tSB\tSC\tSD\tSE\tSF");
		for (int i = 0; i < solutionOrder.length; i++) {
			System.out.print("Position " + (i + 1) + ": ");
			solutionOrder[i].printTileInfo();
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------");

	}

	private boolean canBePlaced(Hexagon[] solution, int currentSolutionIndex, Hexagon currentHex) {
		// If there is nothing in middle then place there
		if (solution[0] == null) {
			return true;
		}

		// If tile is repeated then you cannot place
		if (!notRepeated(solution, currentHex)) {
			return false;
		}

		// check if solution[currPos] exists //if true -> false
		if (solution[currentSolutionIndex] != null) {
			return false;
		}

		// check if center hexagon's colors correspond with current hex's colors
		for (int index = 1, currentHexSide = 3, firstHexCurrentSide = 0; index < 7; index++, currentHexSide++, firstHexCurrentSide++) {
			// make sure that there we look at all the colors in the Hexagon within bounds
			if (currentHexSide > 5) {
				currentHexSide = 0;
			}
			if (index == currentSolutionIndex && currentHex.getColorAtIndex(currentHexSide) != solution[0]
					.getColorAtIndex(firstHexCurrentSide)) {
				return false;
			}
		}

		// check if the hexagon before current hexagon has the same color
		for (int index = 2, currentHexColorIndex = 5, previousPositionColorIndex = 2; index < 7; index++, currentHexColorIndex++, previousPositionColorIndex++) {
			if (currentHexColorIndex > 5) {
				currentHexColorIndex = 0;
			}
			if (previousPositionColorIndex > 5) {
				previousPositionColorIndex = 0;
			}
			if (currentSolutionIndex == index && currentHex.getColorAtIndex(currentHexColorIndex) != solution[index - 1]
					.getColorAtIndex(previousPositionColorIndex)) {
				return false;
			}
		}

		// Check if the last hexagon works clockwise 
		if (currentSolutionIndex == 6 && currentHex.getColorAtIndex(1) != solution[1].getColorAtIndex(4)) {
			return false;
		}

		// If all the statements above are true then the current Hex can be placed
		return true;
	}

	// Checks to make sure the current Hexagon is not repeated in the solution
	public boolean notRepeated(Hexagon[] solutionArray, Hexagon currentHexagon) {
		boolean isNotRepeated = true;
		// Go through all values in solutionArray
		for (int index = 0; index < solutionArray.length; index++) {
			// Check to make sure the current value is not null
			if (solutionArray[index] != null) {
				// Check to make sure the current value is not repeated
				if (solutionArray[index].getTileNumber().equals(currentHexagon.getTileNumber())) {
					isNotRepeated = false;
				}
			}
		}
		return isNotRepeated;
	}

	// acts as the base case helper method
	public boolean positionSevenValid(Hexagon[] solutionHolder) {
		Hexagon position7 = solutionHolder[6];
		Hexagon position6 = solutionHolder[5];
		Hexagon position1 = solutionHolder[0];
		Hexagon position2 = solutionHolder[1];
		if (solutionHolder[6] != null) {
			if (position7.getColorAtIndex(3) == position6.getColorAtIndex(0)
					&& position7.getColorAtIndex(2) == position1.getColorAtIndex(5)
					&& position7.getColorAtIndex(1) == position2.getColorAtIndex(4)) {
				return true;
			}
		}
		return false;
	}

}
