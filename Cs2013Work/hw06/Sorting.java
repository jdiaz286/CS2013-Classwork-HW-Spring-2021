package hw06;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to create all sorting methods
 * Other Comments: 
 */

public class Sorting {

	private Sorting() {

	}

	// insertion sort algorithm
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		Instant start = Instant.now();
		// go through all indexes of the list
		for (int i = 1; i <= list.size()-1; i++) {
			// holds temporary value at index i
			E temp = list.get(i);
			// save j as current index i
			int j = i;
			// sort everything in the list
			while ((j > 0) && (temp.compareTo(list.get(j-1)) < 0) ) {
				// set to current j index if temp is less than j-1 index
				list.set(j, list.get(j-1));
				j--;
			}
			// set j equal to temp value (less than value)
			list.set(j, temp);
		}
		Instant end = Instant.now();
		System.out.print("Time: "+Duration.between(start, end)+"\t");
	}

	// bubble sort algorithm
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		Instant start = Instant.now();
		// boolean variable that will check if everything is swapped
		boolean swapped = false;
		for (int i = 1; i <= list.size() - 1; i++) {
			swapped = false;
			for (int j = 0; j <= list.size() - 2; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					// swap list[j] and list[j+1]
					E temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
					swapped = true;
				}
			}
			// avoids iteration through a sorted list
			if (!swapped) {
				break;
			}
		}
		Instant end = Instant.now();
		System.out.print("Time: "+Duration.between(start, end)+"\t");
	}

	// selection sort algorithm
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		Instant start=Instant.now();
		// outer loop to keep track of min index
		for (int i = 0; i <= list.size() - 1; i++) {
			// save min index
			int min = i;
			// loop through ArrayList to find min (if exists)
			for (int j = i + 1; j <= list.size() - 1; j++) {
				// if there is a lesser value, save index
				if (list.get(j).compareTo(list.get(min)) < 0) {
					min = j;
				}
			}
			// swap list[i] and list[min]
			E temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
		Instant end = Instant.now();
		System.out.print("Time: "+Duration.between(start, end)+"\t");

	}

	// merge sort algorithm
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		// check to make sure there are at least 2 items in list
		if(list.size()>1) {
			// calc midpoint
			int mid=(list.size()-1)/2;
			// "separate" left side of list
			ArrayList<E> left=copyElements(list,0,mid);
			// recursively sort left side of list
			mergeSort(left);
			
			// "separate" right side of list
			ArrayList<E> right=copyElements(list,mid+1,list.size()-1);
			// recursively sort right side of list
			mergeSort(right);
			// when both sides are sorted, combine them
			merge(left,right,list);
		}

	}
	
	// method to merge two lists into one
	private static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> result) {
		// ints to track current position of each list
		int i = 0, j = 0, k = 0;
		// loop until the end of list1 and list2
		while (i < list1.size() && j < list2.size()) {
			// same as "if list1[i]<list2[j]"
			if (list1.get(i).compareTo(list2.get(j)) < 0) {
				// set result[k]=list1[i]
				result.set(k, list1.get(i));
				i++;
			} else {
				// set result[k]=list2[j]
				result.set(k, list2.get(j));
				j++;
			}
			k++;
		}
		// if there are any elements left in list1, add
		while(i<list1.size()) {
			result.set(k, list1.get(i));
			i++;
			k++;
		}
		// if there are any elements left in list2, add
		while(j<list2.size()) {
			result.set(k, list2.get(j));
			j++;
			k++;
		}
	}
	
	// This method is just used to copy elements for mergeSort()
	private static <E extends Comparable<E>> ArrayList<E> copyElements(ArrayList<E> list, int beginning, int ending) {
		// create ArrayList to return
		ArrayList<E> returnedList = new ArrayList<E>();
		// add the current value from list to returnedList
		for (int i = beginning; i <= ending; i++) {
			returnedList.add(list.get(i));
		}
		return returnedList;
	}

	// quick sort algorithm
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		// calls quickSort() with args list, low, high
		quickSort(list, 0, list.size() - 1);

	}

	// this method is meant to solve smaller instances of list for quick sort
	private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int low, int high) {
		// check to make sure the lower index is less than higher index
		if (low < high) {
			// save new pivot point returned from partition()
			int p = partition(list, low, high);
			// recursively sort smaller instances of list (left and right of pivot)
			quickSort(list, low, p - 1);
			quickSort(list, p + 1, high);
		}
	}

	// this method is used to find pivot point for quick sort, returns int
	private static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high) {
		// save pivot point, int this case the highest index
		E pivot = list.get(high);
		int i = low - 1;
		// loop from low to high
		for (int j = low; j <= high - 1; j++) {
			// check if list[j]<=pivot
			if (list.get(j).compareTo(pivot) <= 0) {
				i = i + 1;
				// swap list[i] and list[j] 
				E temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		// swap list[i+1] with list[high]
		E temp = list.get(i + 1);
		list.set(i+1, list.get(high));
		list.set(high, temp);
		// return new pivot point
		return i + 1;
	}

	// counting sort algorithm
	public static void countingSort(ArrayList<Integer> list, int k) {
		Instant start=Instant.now();
		// list that is sorted
		int[] result = new int[list.size()];
		// keeps track of frequency of numbers in list
		int[] counts = new int[k];

		// fill counts with all 0's
		for (int i = 0; i <= k - 1; i++) {
			counts[i] = 0;
		}
		// go through list to count num of times value is in list
		for (int i = 0; i <= list.size()-1; i++) {
			counts[list.get(i)]++;
		}
		//increment add the sum of i-1 to i
		for(int i=1;i<=k-1;i++) {
			counts[i]+=counts[i-1];
		}
		// calculate where list[i] belongs in result
		for (int i = list.size() - 1; i >= 0; i--) {
			result[counts[list.get(i)] - 1] = list.get(i);
			counts[list.get(i)]--;
		}
		//change all values from list to match result
		for(int i=0;i<list.size();i++) {
			list.set(i,result[i]);
		}
		Instant end = Instant.now();
		System.out.print("Time: "+Duration.between(start, end)+"\t");

	}

	// radix sort algorithm
	public static void radixSort(ArrayList<Integer> list) {
		Instant start=Instant.now();
		// creates 10 buckets (valued 0-9)
		List<Integer>[] buckets = new ArrayList[10];
		// initialize all of the buckets
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList();
		}
		// sort until till the highest num of digits is sorted
		int highestDigits = findMaxDigits(list);
		for (int i = 1; i <= highestDigits; i++) {
			// loop through all values in the list
			for (int j = 0; j <= list.size() - 1; j++) {
				// get the ith least significant digit
				int key = list.get(j) / (int) Math.pow(10, i - 1) % 10;
				// add value from list[j] to correct bucket
				buckets[key].add(list.get(j));
			}
			int k = 0;
			// go through all the buckets with or without values and "reset" buckets
			for (int j = 0; j <= buckets.length - 1; j++) {
				// get all elements in the bucket
				for (Integer x : buckets[j]) {
					list.set(k++, x);
				}
				// clear list at buckets[j]
				buckets[j].clear();
			}
		}
		Instant end = Instant.now();
		System.out.print("Time: "+Duration.between(start, end)+"\t");

	}
	
	// method to find the highest number of digits in a list of integers
	private static int findMaxDigits(ArrayList<Integer> list) {
		int max=0;
		// loop to find max value
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>=max) {
				max=list.get(i);
			}
		}
		//calculate the number of digits
		int numOfDigits=(int)(Math.log10(max)+1);
		return numOfDigits;
	}

}


