package hw02;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be a custom class to test MyArray
 * Other Comments: 
 */

public class Student implements Comparable<Student>{
	private String name;
	private double gpa;

	public Student(String typedName, double typedGPA) {
		name = typedName;
		gpa = typedGPA;
	}

	public void setName(String typedName) {
		name = typedName;
	}

	public void setGPA(String typedGPA) {
		name = typedGPA;
	}

	public String getName() {
		return name;
	}

	public double getGPA() {
		return gpa;
	}

	public String toString() {
		return "Name- " + getName() + " GPA- " + getGPA();
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
