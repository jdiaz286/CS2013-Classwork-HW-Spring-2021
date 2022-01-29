package hw02;


/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to build an array using generics
 * Other Comments: The shift methods manipulate the second array after the array is shuffled. 
 * Below you will find the class being tested with ints, doubles, strings, chars, and a custom class Student (in that order)
 */
public class Main {
	public static void main(String[] args) {
		// Demonstration of class with integers
		System.out.println("\tDemonstration of MyArray with integers");
		MyArray<Integer> firstArrayOfInts = new MyArray<>(8);  // First way to invoke constructor
		MyArray<Integer> secondArrayOfInts = new MyArray<Integer>(12, 6, 4, 7, 2, 123, 5);  // Second way to invoke constructor
		MyArray secondArrayCopy = new MyArray(12, 6, 4, 7, 2, 123, 5);
		firstArrayOfInts.put(0, 7, 12, 6, 4, 7, 2, 123, 5, 1);	// Put values in specified order
		System.out.print("Values in first array: ");
		firstArrayOfInts.toString();	// Use of toString()
		System.out.print("\nValues in the second array: ");
		secondArrayOfInts.toString();
		System.out.print("\nValues in the second array copy: ");
		secondArrayCopy.toString();
		int valIndexZero = firstArrayOfInts.get(0);	// Use of get() for one value
		System.out.println("\nValue of index 0 in first array: " + valIndexZero);
		MyArray specifiedVals=secondArrayOfInts.get(2,4);	// Use of get() to return MyArray object
		System.out.print("Values from index 2-4 (inclusive) in second array: ");
		specifiedVals.toString();
		System.out.println("\nAre the second array and its copy the same: "+secondArrayOfInts.equals(secondArrayCopy));	// Use of equals() method 
		System.out.println("Are the second array and the first array the same: "+secondArrayOfInts.equals(firstArrayOfInts));
		System.out.println("Max value from second array: "+secondArrayOfInts.max());	// Use of max() method
		System.out.println("Min value from first array: "+firstArrayOfInts.min());
		System.out.print("Values in the second array reversed: ");
		secondArrayOfInts.reverse(); // Use of reverse() method
		secondArrayOfInts.toString();
		System.out.print("\nValues in the second array shuffled randomly: ");
		secondArrayOfInts.shuffle(); // Use of shuffle() method
		secondArrayOfInts.toString();
		System.out.print("\nValues in the second array shifted to the left 3 times: ");
		secondArrayOfInts.leftShift(3); // Use of leftShift() 3 spaces
		secondArrayOfInts.toString();
		System.out.print("\nValues in the second array shifted to the right 1 times: ");
		secondArrayOfInts.rightShift(1); // Use of rightShift() 1 space
		secondArrayOfInts.toString();
		System.out.println("\nSize of the second array: "+secondArrayOfInts.size());
		System.out.print("Values in the second array when sorted: ");
		secondArrayOfInts.sort(); // Use of sort() method
		secondArrayOfInts.toString();
		
		System.out.println("\n");
		
		// Demonstration of class with doubles
		System.out.println("\tDemonstration of MyArray with doubles");
		MyArray<Double> firstArrayOfDoubles = new MyArray<>(8);  // First way to invoke constructor
		MyArray<Double> secondArrayOfDoubles = new MyArray<Double>(1212.65, 26.76, 14.34, 67.56, 25.13, 1.12356, 5.7632);  // Second way to invoke constructor
		MyArray secondArrayCopy1 = new MyArray(1212.65, 26.76, 14.34, 67.56, 25.13, 1.12356, 5.7632);
		firstArrayOfDoubles.put(0, 7, 1.2, 0.6, 1.4, 2.7, 1.2, 12.3, 0.5, 0.1);	// Put values in specified order
		System.out.print("Values in first array: ");
		firstArrayOfDoubles.toString();	// Use of toString()
		System.out.print("\nValues in the second array: ");
		secondArrayOfDoubles.toString();
		System.out.print("\nValues in the second array copy: ");
		secondArrayCopy1.toString();
		double valIndexZero1 = firstArrayOfDoubles.get(0);	// Use of get() for one value
		System.out.println("\nValue of index 0 in first array: " + valIndexZero1);
		MyArray specifiedVals1=secondArrayOfDoubles.get(2,4);	// Use of get() to return MyArray object
		System.out.print("Values from index 2-4 (inclusive) in second array: ");
		specifiedVals1.toString();
		System.out.println("\nAre the second array and its copy the same: "+secondArrayOfDoubles.equals(secondArrayCopy1));	// Use of equals() method 
		System.out.println("Are the second array and the first array the same: "+secondArrayOfDoubles.equals(firstArrayOfDoubles));
		System.out.println("Max value from second array: "+secondArrayOfDoubles.max());	// Use of max() method
		System.out.println("Min value from first array: "+firstArrayOfDoubles.min());
		System.out.print("Values in the second array reversed: ");
		secondArrayOfDoubles.reverse(); // Use of reverse() method
		secondArrayOfDoubles.toString();
		System.out.print("\nValues in the second array shuffled randomly: ");
		secondArrayOfDoubles.shuffle(); // Use of shuffle() method
		secondArrayOfDoubles.toString();
		System.out.print("\nValues in the second array shifted to the left 3 times: ");
		secondArrayOfDoubles.leftShift(3); // Use of leftShift() 3 spaces
		secondArrayOfDoubles.toString();
		System.out.print("\nValues in the second array shifted to the right 1 times: ");
		secondArrayOfDoubles.rightShift(1); // Use of rightShift() 1 space
		secondArrayOfDoubles.toString();
		System.out.println("\nSize of the second array: "+secondArrayOfDoubles.size());
		System.out.print("Values in the second array when sorted: ");
		secondArrayOfDoubles.sort(); // Use of sort() method
		secondArrayOfDoubles.toString();
		
		System.out.println("\n");
		
		// Demonstration of class with Strings
		System.out.println("\tDemonstration of MyArray with strings");
		MyArray<String> firstArrayOfStrings = new MyArray<>(2);  // First way to invoke constructor
		MyArray<String> secondArrayOfStrings = new MyArray<String>("Hello", "my", "name", "is", "Jonathan", "Diaz");  // Second way to invoke constructor
		MyArray secondArrayCopy2 = new MyArray("Hello", "my", "name", "is", "Jonathan", "Diaz");
		firstArrayOfStrings.put(0, 1, "Hello","World");	// Put values in specified order
		System.out.print("Values in first array: ");
		firstArrayOfStrings.toString();	// Use of toString()
		System.out.print("\nValues in the second array: ");
		secondArrayOfStrings.toString();
		System.out.print("\nValues in the second array copy: ");
		secondArrayCopy2.toString();
		String valIndexZero2 = firstArrayOfStrings.get(0);	// Use of get() for one value
		System.out.println("\nValue of index 0 in first array: " + valIndexZero2);
		MyArray specifiedVals2=secondArrayOfStrings.get(2,4);	// Use of get() to return MyArray object
		System.out.print("Values from index 2-4 (inclusive) in second array: ");
		specifiedVals2.toString();
		System.out.println("\nAre the second array and its copy the same: "+secondArrayOfStrings.equals(secondArrayCopy2));	// Use of equals() method 
		System.out.println("Are the second array and the first array the same: "+secondArrayOfStrings.equals(firstArrayOfStrings));
		System.out.println("Max value from second array: "+secondArrayOfStrings.max());	// Use of max() method
		System.out.println("Min value from first array: "+firstArrayOfStrings.min());
		System.out.print("Values in the second array reversed: ");
		secondArrayOfStrings.reverse(); // Use of reverse() method
		secondArrayOfStrings.toString();
		System.out.print("\nValues in the second array shuffled randomly: ");
		secondArrayOfStrings.shuffle(); // Use of shuffle() method
		secondArrayOfStrings.toString();
		System.out.print("\nValues in the second array shifted to the left 3 times: ");
		secondArrayOfStrings.leftShift(3); // Use of leftShift() 3 spaces
		secondArrayOfStrings.toString();
		System.out.print("\nValues in the second array shifted to the right 1 times: ");
		secondArrayOfStrings.rightShift(1); // Use of rightShift() 1 space
		secondArrayOfStrings.toString();
		System.out.println("\nSize of the second array: "+secondArrayOfStrings.size());
		System.out.print("Values in the second array when sorted: ");
		secondArrayOfStrings.sort(); // Use of sort() method
		secondArrayOfStrings.toString();
		
		System.out.println("\n");
		
		// Demonstration of class with chars
		System.out.println("\tDemonstration of MyArray with chars");
		MyArray<Character> firstArrayOfChars = new MyArray<>(4);  // First way to invoke constructor
		MyArray<Character> secondArrayOfChars = new MyArray<Character>('v', 'K', '5', 'f', 'H', 'R', 'k', 'j', 'O', 'K');  // Second way to invoke constructor
		MyArray secondArrayCopy3 = new MyArray('v', 'K', '5', 'f', 'H', 'R', 'k', 'j', 'O', 'K');
		firstArrayOfChars.put(0, 3, 'a','T','&','t');	// Put values in specified order
		System.out.print("Values in first array: ");
		firstArrayOfChars.toString();	// Use of toString()
		System.out.print("\nValues in the second array: ");
		secondArrayOfChars.toString();
		System.out.print("\nValues in the second array copy: ");
		secondArrayCopy3.toString();
		Character valIndexZero3 = firstArrayOfChars.get(0);	// Use of get() for one value
		System.out.println("\nValue of index 0 in first array: " + valIndexZero3);
		MyArray specifiedVals3=secondArrayOfChars.get(2,4);	// Use of get() to return MyArray object
		System.out.print("Values from index 2-4 (inclusive) in second array: ");
		specifiedVals3.toString();
		System.out.println("\nAre the second array and its copy the same: "+secondArrayOfChars.equals(secondArrayCopy3));	// Use of equals() method 
		System.out.println("Are the second array and the first array the same: "+secondArrayOfChars.equals(firstArrayOfChars));
		System.out.println("Max value from second array: "+secondArrayOfChars.max());	// Use of max() method
		System.out.println("Min value from first array: "+firstArrayOfChars.min());
		System.out.print("Values in the second array reversed: ");
		secondArrayOfChars.reverse(); // Use of reverse() method
		secondArrayOfChars.toString();
		System.out.print("\nValues in the second array shuffled randomly: ");
		secondArrayOfChars.shuffle(); // Use of shuffle() method
		secondArrayOfChars.toString();
		System.out.print("\nValues in the second array shifted to the left 3 times: ");
		secondArrayOfChars.leftShift(3); // Use of leftShift() 3 spaces
		secondArrayOfChars.toString();
		System.out.print("\nValues in the second array shifted to the right 1 times: ");
		secondArrayOfChars.rightShift(1); // Use of rightShift() 1 space
		secondArrayOfChars.toString();
		System.out.println("\nSize of the second array: "+secondArrayOfChars.size());
		System.out.print("Values in the second array when sorted: ");
		secondArrayOfChars.sort(); // Use of sort() method
		secondArrayOfChars.toString();
		
		System.out.println("\n");
		
		// Demonstration of class with custom class Student
		System.out.println("\tDemonstration of MyArray with custom class Student");
		MyArray<Student> firstArrayOfStudents = new MyArray<>(2);  // First way to invoke constructor
		MyArray<Student> secondArrayOfStudents = new MyArray<Student>( new Student("Natalie", 3.75),new Student("Ernesto", 3.44),new Student("Jackie", 3.99));  // Second way to invoke constructor
		MyArray secondArrayCopy4 = new MyArray<Student>(new Student("Natalie", 3.75),new Student("Ernesto", 3.44),new Student("Jackie", 3.99));
		firstArrayOfStudents.put(0,1,new Student("Diana",4.00), new Student("Beatriz",3.99));	// Put values in specified order
		System.out.print("Values in first array: ");
		firstArrayOfStudents.toString();	// Use of toString()
		System.out.print("\nValues in the second array: ");
		secondArrayOfStudents.toString();
		System.out.print("\nValues in the second array copy: ");
		secondArrayCopy4.toString();
		Student valIndexZero4 = firstArrayOfStudents.get(0);	// Use of get() for one value
		System.out.println("\nValue of index 0 in first array: " + valIndexZero4);
		MyArray specifiedVals4=secondArrayOfStudents.get(1,2);	// Use of get() to return MyArray object
		System.out.print("Values from index 1-2 (inclusive) in second array: ");
		specifiedVals4.toString();
		System.out.println("\nAre the second array and its copy the same: "+secondArrayOfStudents.equals(secondArrayCopy4));	// Use of equals() method 
		System.out.println("Are the second array and the first array the same: "+secondArrayOfStudents.equals(firstArrayOfStudents));
		System.out.println("Max value from second array: "+secondArrayOfStudents.max());	// Use of max() method
		System.out.println("Min value from first array: "+firstArrayOfStudents.min());
		System.out.print("Values in the second array reversed: ");
		secondArrayOfStudents.reverse(); // Use of reverse() method
		secondArrayOfStudents.toString();
		System.out.print("\nValues in the second array shuffled randomly: ");
		secondArrayOfStudents.shuffle(); // Use of shuffle() method
		secondArrayOfStudents.toString();
		System.out.print("\nValues in the second array shifted to the left 3 times: ");
		secondArrayOfStudents.leftShift(3); // Use of leftShift() 3 spaces
		secondArrayOfStudents.toString();
		System.out.print("\nValues in the second array shifted to the right 1 times: ");
		secondArrayOfStudents.rightShift(1); // Use of rightShift() 1 space
		secondArrayOfStudents.toString();
		System.out.println("\nSize of the second array: "+secondArrayOfStudents.size());
		System.out.print("Values in the second array when sorted: ");
		secondArrayOfStudents.sort(); // Use of sort() method
		secondArrayOfStudents.toString();
		
	}
}
