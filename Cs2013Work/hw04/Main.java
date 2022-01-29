package hw04;


/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to test out the SortedSet class
 * Other Comments: 
 */
public class Main {
	public static void main(String[] args) {

		System.out.println("------------SortedSet using String----------");
		SortedSet firstStrings = new SortedSet(); // testing SortedSet() with no args
		firstStrings.addAll("hello", "my", "name", "is", "jonathan"); // testing addAll() method
		SortedSet secondStrings = new SortedSet("Hello", "my", "name", "is", "Jonathan", "Diaz"); // test SortedSet(E...values)
		SortedSet thirdStrings = new SortedSet(2); // make a set with capacity 2
		thirdStrings.add("Hello");
		thirdStrings.add("there"); // testing the add method
		SortedSet secondStringsCopy = new SortedSet(secondStrings); // testing SortedSet(copy)
		System.out.println("first set:\t\t" + firstStrings.toString());
		System.out.println("second set:\t\t" + secondStrings.toString());
		System.out.println("third set:\t\t" + thirdStrings.toString());
		System.out.println("second set copy:\t" + secondStringsCopy.toString());
		System.out.println("\tTesting the exists() method");
		System.out.println("Does the value \"Jonathan\" exist the in first set: " + firstStrings.exists("Jonathan"));
		System.out.println("\tTesting the get() method");
		System.out.println("Value at index 3 in first set: " + firstStrings.get(3));
		System.out.println("\tTesting the remove() method");
		secondStrings.remove("hello"); // tests if remove() removes a valid value
		secondStrings.remove("Hello");
		secondStringsCopy.remove("Hello"); // just to keep the copy identical to original
		System.out.println("Second set after removing \"Hello\": " + secondStrings.toString());
		System.out.println("\tTesting the size() method");
		System.out.println("Size of the third set: " + thirdStrings.size());
		System.out.println("\tTesting the equals() method");
		System.out.println("Are the first set and second set equal?: " + firstStrings.equals(secondStrings));
		System.out.println("Are the second set and second set copy equal?: " + secondStrings.equals(secondStringsCopy));

		System.out.println("\n------------SortedSet using Integers----------");
		SortedSet firstInts = new SortedSet(); // testing SortedSet() with no args
		firstInts.addAll(129646, 184313, 285160, 565541, 718372, 847831, 853704, 951838, 1058856, 1300520, 1418050,
				1429858, 1496994, 1507474, 1572669); // testing addAll() method
		SortedSet secondInts = new SortedSet(1071980, 1079350, 1103935, 1263098, 1319272, 1360704, 1479345, 1482982,
				1603172, 1814723, 1928332); // test SortedSet(E...values)
		SortedSet thirdInts = new SortedSet(4); // make a set with capacity 2
		thirdInts.add(62829);
		thirdInts.add(1235);
		thirdInts.add(98765);
		thirdInts.add(6411); // testing the add method
		SortedSet secondIntsCopy = new SortedSet(secondInts); // testing SortedSet(copy)
		System.out.println("first set:\t\t" + firstInts.toString());
		System.out.println("second set:\t\t" + secondInts.toString());
		System.out.println("third set:\t\t" + thirdInts.toString());
		System.out.println("second set copy:\t" + secondIntsCopy.toString());
		System.out.println("\tTesting the exists() method");
		System.out.println("Does the value \"853704\" exist the in first set: " + firstInts.exists(853704));
		System.out.println("\tTesting the get() method");
		System.out.println("Value at index 3 in first set: " + firstInts.get(3));
		System.out.println("\tTesting the remove() method");
		secondInts.remove(131927214); // tests if remove() removes a valid value
		secondInts.remove(1319272);
		secondIntsCopy.remove(1319272); // just to keep the copy identical to original
		System.out.println("Second set after removing \"Hello\": " + secondInts.toString());
		System.out.println("\tTesting the size() method");
		System.out.println("Size of the third set: " + thirdInts.size());
		System.out.println("\tTesting the equals() method");
		System.out.println("Are the first set and second set equal?: " + firstInts.equals(secondInts));
		System.out.println("Are the second set and second set copy equal?: " + secondInts.equals(secondIntsCopy));
	}
}
