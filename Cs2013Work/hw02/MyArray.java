package hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to build an array using generics
 * Other Comments: 
 */

public class MyArray<E extends Comparable<E>> {
	// No other data fields necessary.
	private E[] data;

	public MyArray(int size) {
		this.data = (E[]) (new Comparable[size]);
	}

	// This constructor can accept an array or a comma-separated list of values.
	public MyArray(E... elements) {
		this.data = (E[]) (new Comparable[elements.length]);
		// Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
	}

	// Take an integer index as a parameter and return the data at the given index.
	public E get(int index) {
		if (index >= data.length)
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + data.length);
		else
			return data[index];
	}

	// return a new MyArray object with values between start and end inclusive.
	public MyArray get(int start, int end) {
		if (start >= data.length)
			throw new IndexOutOfBoundsException("Index: " + start + ", Must be within range: " + data.length);
		else if (end >= data.length)
			throw new IndexOutOfBoundsException("Index: " + end + ", Must be within range: " + data.length);
		else {
			int sizeOfNewArray = end - start + 1;
			MyArray<E> returnedMyArray = new MyArray<>(sizeOfNewArray);
			int indexOfCopy = 0;
			for (int index = start; index <= end; index++) {
				E currentDataToCopy = (E) data[index];
				returnedMyArray.data[indexOfCopy] = currentDataToCopy;
				indexOfCopy++;
			}
			return returnedMyArray;
		}
	}

	// Take index and value and place in given index
	public void put(int index, E value) {
		if (index >= data.length)
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + data.length);
		else
			data[index] = value;
	}

	// Take the elements and place them into the array replacing the values between
	// the start index position and the end
	public void put(int start, int end, E... elements) {
		if (start >= data.length)
			throw new IndexOutOfBoundsException("Index: " + start + ", Must be within range: " + data.length);
		else if (end >= data.length)
			throw new IndexOutOfBoundsException("Index: " + end + ", Must be within range: " + data.length);
		else {
			int sizeOfArray = end - start;
			// if not working below, use: Arrays.stream(elements.split(","))
			E[] temporaryHolder = elements;
			int temporaryHolderIndex = 0;
			for (int index = start; index <= end; index++) {
				data[index] = temporaryHolder[temporaryHolderIndex];
				temporaryHolderIndex++;
			}
		}
	}

	// Returns whether two MyArray objects are equal
	@Override
	public boolean equals(Object o) {
		boolean sameSize = true;
		boolean sameType = true;
		boolean sameOrder = true;
		MyArray otherArray = (MyArray) o;
		if (((MyArray) o).size() != this.size()) { // Check to see if data sets have same size
			sameSize = false;
		}

		if (sameSize) { // Check to see if data arrays have the same values
			if (!Arrays.equals(data, otherArray.data))
				sameOrder = false;
		} else {
			sameOrder = false;
		}

		Class firstArrayType = data[0].getClass(); // Check to see if the values are the same type
		Class secondArrayType = otherArray.data[0].getClass();
		if (sameSize) {
			for (int i = 1; i < data.length; i++) {
				if (firstArrayType != data[i].getClass()) {
					sameType = false;
				}
			}
			for (int i = 1; i < data.length; i++) {
				if (secondArrayType != otherArray.data[i].getClass()) {
					sameType = false;
				}
			}
		}

		if (sameSize && sameType && sameOrder) { // Return t/f accordingly
			return true;
		} else {
			return false;
		}
	}

	// return the max value in the array
	public <E extends Comparable<E>> E max() {
		E maxVal = (E) data[0];
		for (int i = 1; i < data.length; i++) {
			E currentVal = (E) data[i];
			if (currentVal.compareTo(maxVal) > 0) { // >0 if greater than current num
				maxVal = currentVal;
			}
		}
		return maxVal;
	}

	// return the min value in the array
	public <E extends Comparable<E>> E min() {
		E minVal = (E) data[0];
		for (int i = 1; i < data.length; i++) {
			E currentVal = (E) data[i];
			if (currentVal.compareTo(minVal) <= 0) { // <=0 if less than or equal to current num
				minVal = currentVal;
			}
		}
		return minVal;
	}

	// reverse the existing array
	public void reverse() {
		for (int i = 0; i < data.length / 2; i++) {
			E temp = data[i];
			data[i] = data[data.length - i - 1];
			data[data.length - i - 1] = temp;
		}
	}

	// Shuffle the existing array in a random order
	public void shuffle() {
		int index;
		E temp;
		Random rand = new Random();
		for (int i = data.length - 1; i > 0; i--) {
			index = rand.nextInt(i + 1);
			temp = data[index];
			data[index] = data[i];
			data[i] = temp;
		}
	}

	// Move shiftDistance spaces in array to the left
	public void leftShift(int shiftDistance) {
		while (shiftDistance >= 1) {
			E start = data[0];
			for (int i = 0; i < data.length - 1; i++) {
				data[i] = data[i + 1];
			}
			data[data.length - 1] = start;
			shiftDistance--;
		}
	}

	// Move shiftDistance spaces in array to the right
	public void rightShift(int shiftDistance) {
		while (shiftDistance >= 1) {
			E end = data[data.length - 1];
			for (int i = data.length - 2; i >= 0; i--) {
				data[i + 1] = data[i];
			}
			data[0] = end;
			shiftDistance--;
		}
	}

	// Return current size of the array
	public int size() {
		int size = 0;
		for (int index = 0; index < data.length; index++) {
			size++;
		}
		return size;
	}

	// Print a String representation of the array
	public String toString() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str = str + data[i] + ", ";
		}
		str = str.replaceAll(", $", "");
		System.out.print(str);
		return str;
	}

	// Sort the array
	public void sort() {
		boolean isSorted = false;
		int currentMinIndex;
		E currentMin;
		while (!isSorted) {
			for (int firstIndex = 0; firstIndex < data.length - 1; firstIndex++) {
				currentMin = (E) data[firstIndex];
				currentMinIndex = firstIndex;
				for (int secondIndex = firstIndex + 1; secondIndex < data.length; secondIndex++) {
					if (currentMin.compareTo((E) data[secondIndex]) > 0) {
						currentMin = (E) data[secondIndex];
						currentMinIndex = secondIndex;
					}
				}

				// Swap list[i] with list[currentMinIndex] if necessary;
				if (currentMinIndex != firstIndex) {
					data[currentMinIndex] = data[firstIndex];
					data[firstIndex] = (E) currentMin;
				}
			}
			isSorted = true;
		}
	}
}