package hw04;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to build a sorted set
 * Other Comments: 
 */
import java.util.Arrays;

public class SortedSet<E extends Comparable<E>> {
	private int size = 0;
	E[] set = (E[]) (new Comparable[size]);

	// Default constructor creates new set with default capacity 10
	public SortedSet() {
		set = (E[]) (new Comparable[10]);
	}

	// Constructor takes int parameter and sets size to that int
	public SortedSet(int capacity) {
		set = (E[]) (new Comparable[capacity]);
	}

	// Constructor that accepts comma separated list of generic values as parameter
	public SortedSet(E... values) {
		// Just to instantiate the set[]
		set = (E[]) (new Comparable[10]);
		// Implement addAll()
		addAll(values);
	}

	// Constructor that makes a copy of another SortedSet
	public SortedSet(SortedSet desiredCopySet) {
		size = desiredCopySet.size;
		// To instantiate the set[]
		set = (E[]) (new Comparable[desiredCopySet.set.length]);
		System.arraycopy(desiredCopySet.set, 0, set, 0, desiredCopySet.size);
	}

	// Checks whether or not the given value already exists within your set.
	public boolean exists(E value) {
		// Implements a binary search using compareTo() // if true -> the set has the
		// value
		// If false -> the set does not have the value
		return binarySearch(set, 0, size, value);
	}

	// Add a value if it does not exist in the set
	public void add(E value) {
		if ((size + 1) >= set.length - 1) {
			// If not enough space then resize()
			resize();
			placeCorrectLocation(value);
			Arrays.sort(set, 0, size - 1);
		}
		// If there is enough space then just add to set in order
		else {
			// Place in correct location
			placeCorrectLocation(value);
			Arrays.sort(set, 0, size);
		}

	}

	// Add all of the given values from the set as long as they are not duplicated
	public void addAll(E... values) {
		// go through all the values in the temporary array
		for (int index = 0; index < values.length; index++) {
			// implement the add() method and pass the current value at index
			add(values[index]);
		}
	}

	// Remove value in set if it exists
	public void remove(E value) {
		// since size is only one, change set[0] to null
		if (size == 1) {
			if (exists(value)) {
				set[0] = null;
			}
		}
		// if the size of the set is greater than 1
		else {
			// check to make sure the value is in set
			if (exists(value)) {
				// go through list and find the index where value is at
				removeAtCorrectLocation(value);
			}
			// if not then do nothing
			else {
				System.out.println("Value \"" + value + "\" not found in set.");
			}
		}
	}

	// Return the value stored at the given index in the set
	public E get(int index) {
		// make sure that the index is within size range
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + size);
		} else {
			// if the index is in range, return the value
			return set[index];
		}

	}

	// Return the size (number of elements) in the set
	public int size() {
		// this would be O(1) runtime
		return size;
	}

	// Take a SortedSet object and determine if the two are equal or not
	@Override
	public boolean equals(Object o) {
		SortedSet otherSet = (SortedSet) o;
		// "equal... if they have the same number of elements and if they both contain
		// the same set of elements in the same order."
		boolean sameNumOfElements = false;
		boolean sameElementsOrder = true;

		// check to make sure both have the same elements
		if (otherSet.size == size) {
			sameNumOfElements = true;
		}
		// check to see if both in same order and same set
		if (sameNumOfElements) { // make sure both have same size
			for (int index = 0; index < size; index++) {
				if (set[index].compareTo((E) otherSet.set[index]) != 0) {
					sameElementsOrder = false;
				}
			}
		}

		// if one is false -> return false
		// if both are true -> return true
		return (sameNumOfElements && sameElementsOrder);

	}

	// Print out all values in set {val1, val2,...}
	public String toString() {
		// Use a StringBuilder to be a bit more efficient
		StringBuilder stringOfValues = new StringBuilder();
		stringOfValues.append("{");
		// Go through the set and add to string builder if not null
		for (int index = 0; index < set.length; index++) {
			if (set[index] != null) {
				// Add value to StringBuilder
				stringOfValues.append(set[index]);
				// Checks to make sure to not add extra comma
				if (index < size() - 1) {
					stringOfValues.append(", ");
				}
			}
		}
		stringOfValues.append("}");
		return stringOfValues.toString();
	}

	// Responsible for resizing the capacity of the set when the set becomes full
	private void resize() {
		// Create a new array with twice the original length
		E[] doubleSizeArray = (E[]) (new Comparable[set.length * 2]);
		// copy all values in the original set
		System.arraycopy(set, 0, doubleSizeArray, 0, set.length);
		// Change reference of original array to bigger
		set = doubleSizeArray;
	}

	// Helper methods to help keep code organized
	// Implement a binary search of the list
	private boolean binarySearch(E[] set, int firstIndex, int lastIndex, E desiredValue) {
		// Makes sure the lastIndex greater than/equal to firstIndex
		if (lastIndex >= firstIndex) {
			// Compute the midpoint
			int mid = (lastIndex + firstIndex) / 2;
			// avoid NullPointerException if value is null
			if (set[mid] != null) {
				// 0 if the current midPoint is equal to the desiredValue, compareTo() returns 0
				if (set[mid].compareTo(desiredValue) == 0) {
					return true;
				}
				// > 0 if the midpoint is greater than the desiredValue -> more characters
				else if (set[mid].compareTo(desiredValue) > 0) {
					// Look to the left of the set by subtracting one to midpoint
					return binarySearch(set, firstIndex, mid - 1, desiredValue);
				}
				// < 0 if the midpoint is less than the desiredValue -> less characters
				else if (set[mid].compareTo(desiredValue) < 0) {
					// Look to the right by adding one to midpoint
					return binarySearch(set, mid + 1, lastIndex, desiredValue);
				}
			}

		}
		// Return false if the firstIndex is greater than lastIndex
		return false;
	}

	// Go through set and place value in right location, move as necessary
	private void placeCorrectLocation(E value) {
		// Check if the value exists() in the set
		if (!exists(value)) {
			set[size] = value;
			size++;
		}
	}

	// Method to find and remove a value from set
	private void removeAtCorrectLocation(E value) {
		int indexToRemove = 0;
		for (int index = 0; index < set.length; index++) {
			// avoids NullPointerException
			if (set[index] != null) {
				// Checks to see if value is less than index before and greater than index after
				if (value.compareTo(set[index]) == 0) {
					// Set the index to be placed to current Index
					indexToRemove = index;
				}
				// If the value is greater than the value at current index, skip
				else if (value.compareTo(set[index]) > 0) {
					// Does nothing in the loop and nothing to the set
					continue;
				}
			}
		}
		set[indexToRemove] = null;
		System.arraycopy(set, indexToRemove + 1, set, indexToRemove, (set.length - indexToRemove - 1));
		size--;

	}

}
