package hw06;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to demonstrate all sorting methods
 * Other Comments: 
 */
public class Main {
	public static void main(String[] args) {
		// create an array that will hold copies of each a
		// read data from all files
		FileDataReader firstDataSet = new FileDataReader("50000.txt");
		FileDataReader secondDataSet = new FileDataReader("100000.txt");
		FileDataReader thirdDataSet = new FileDataReader("150000.txt");
		FileDataReader fourthDataSet = new FileDataReader("200000.txt");
		FileDataReader fifthDataSet = new FileDataReader("250000.txt");

		// get the values from each file and save as ArrayList
		ArrayList<Integer> firstData = firstDataSet.getValues();
		ArrayList<Integer> secondData = secondDataSet.getValues();
		ArrayList<Integer> thirdData = thirdDataSet.getValues();
		ArrayList<Integer> fourthData = fourthDataSet.getValues();
		ArrayList<Integer> fifthData = fifthDataSet.getValues();

		//create and instantiate array that will hold instances of fileData
		ArrayList<Integer>[] fileDataInstances=new ArrayList[35];
		for(int i=0;i<fileDataInstances.length;i+=5) {
			fileDataInstances[i]=firstData;
			fileDataInstances[i+1]=secondData;
			fileDataInstances[i+2]=thirdData;
			fileDataInstances[i+3]=fourthData;
			fileDataInstances[i+4]=fifthData;
		}
		// this array is just to track the name of the file
		String[] fileName= {"50000.txt","100000.txt","150000.txt","200000.txt","250000.txt"};
		// this array is keep track on Duration of 
		Duration[] quickSortDurations=new Duration[5];
		
		// this loop goes through to record the different times of quickSort
		for(int i=0; i<5;i++) {
			Instant startQuickSort=Instant.now();
			Sorting.quickSort(fileDataInstances[i+20]);
			Instant endQuickSort = Instant.now();
			quickSortDurations[i]=Duration.between(startQuickSort, endQuickSort);
		}
		
		// print out all Duration's for sorting methods
		int index=0;
		System.out.println("Results table " +  "----------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\tInsertion Sort\t\tBubble Sort\tSelection Sort\t\tMerge Sort\tQuick Sort\t\tCounting Sort\t\tRadix Sort");
		for (int i = 0; i < 5; i++) {
			System.out.print(fileName[index]+ ": ");
			Sorting.insertionSort(fileDataInstances[i]);
			Sorting.bubbleSort(fileDataInstances[i+5]);
			Sorting.selectionSort(fileDataInstances[i+10]);
			Instant startMergeSort=Instant.now();
			Sorting.mergeSort(fileDataInstances[i+15]);
			Instant endMergeSort = Instant.now();
			System.out.print("Time: "+Duration.between(startMergeSort, endMergeSort)+"\t");
			System.out.print(quickSortDurations[i]+"\t");
			Sorting.countingSort(fileDataInstances[i+25],1000);
			Sorting.radixSort(fileDataInstances[i+30]);
			System.out.println();
			index++;
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		
	}
}
