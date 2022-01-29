package hw04;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to use SortedSets to find union and intersection of 2 SortedSets
 * Other Comments: 
 */
public class SortedSetUtils {
	// Default constructor
	private SortedSetUtils() {

	}

	// Return a SortedSet of the distinct values in two different sets (union)
	public static <E> SortedSet union(SortedSet firstSet, SortedSet secondSet) {
		SortedSet unionSet = new SortedSet();
		int firstSetIndex = 0, secondSetIndex = 0;
		// repeat in a while loop until we have reached the end of both arrays' size
		// keep in mind that each set may have different sizes
		while (firstSetIndex != firstSet.size() && secondSetIndex != secondSet.size()) {
			// get the values at currentIndexes and save
			E firstSetCurrentVal = (E) firstSet.set[firstSetIndex];
			E secondSetCurrentVal = (E) secondSet.set[secondSetIndex];

			// add() current values in each set
			unionSet.add((Comparable) firstSetCurrentVal);
			unionSet.add((Comparable) secondSetCurrentVal);

			// increment both indexes
			firstSetIndex++;
			secondSetIndex++;
		}
		return unionSet;
	}

	// Return a SortedSet of the common values in two different sets (intersection)
	public static <E> SortedSet intersection(SortedSet firstSet, SortedSet secondSet) {
		SortedSet intersectionSet = new SortedSet();
		// go through the values in the first set and check if in second set
		for (int index = 0; index < firstSet.size(); index++) {
			// save value at current index in first set
			E currentValueSetOne = (E) firstSet.get(index);
			// check if the value exists in the second set -> true if found
			if (secondSet.exists((Comparable) currentValueSetOne)) {
				// add to intersection set if true
				intersectionSet.add((Comparable) currentValueSetOne);
			}
		}

		return intersectionSet;
	}

	// main() method is used to test union() and intersection()
	public static void main(String[] args) {
		System.out.println("------------Union and Intersection with Integers----------");
		SortedSet firstSetIntegers = new SortedSet(1, 2, 3, 4, 5);
		SortedSet secondSetIntegers = new SortedSet(1, 3, 5, 6, 10);
		System.out.println("first set values: "+firstSetIntegers.toString());
		System.out.println("second set values: "+secondSetIntegers.toString());
		
		System.out.println("\tUnion of first and second set ");
		SortedSet unionInts=union(firstSetIntegers,secondSetIntegers);
		System.out.println("Exepected:\t{1, 2, 3, 4, 5, 6, 10}");
		System.out.println("Result:\t\t"+unionInts.toString());
		
		System.out.println("\tIntersection of first and second set ");
		SortedSet intersectionInts=intersection(firstSetIntegers,secondSetIntegers);
		System.out.println("Exepected:\t{1, 3, 5}");
		System.out.println("Result:\t\t"+intersectionInts.toString());
		
		System.out.println();
		System.out.println("------------Union and Intersection with Strings----------");
		SortedSet firstSetStrings = new SortedSet("Hello", "my", "name", "is", "Jonathan", "Diaz");
		SortedSet secondSetStrings = new SortedSet("Hello", "my", "name", "is", "Bob");
		System.out.println("first set values: "+firstSetStrings.toString());
		System.out.println("second set values: "+secondSetStrings.toString());
		
		System.out.println("\tUnion of first and second set ");
		SortedSet unionStrings=union(firstSetStrings,secondSetStrings);
		System.out.println("Exepected:\t{Bob, Diaz, Hello, Jonathan, is, my, name}");
		System.out.println("Result:\t\t"+unionStrings.toString());
		
		System.out.println("\tIntersection of first and second set ");
		SortedSet intersectionStrings=intersection(firstSetStrings,secondSetStrings);
		System.out.println("Exepected:\t{Hello, is, my, name}");
		System.out.println("Result:\t\t"+intersectionStrings.toString());
	}
	
}
