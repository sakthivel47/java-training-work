package problemrecursion;

import java.util.Scanner;

public class RecursionProblem {
	
	public static int sumOfEveryElement(int arr[], int size) {
		if(size == 0) {
			return arr[size];
		}
		return arr[size] + sumOfEveryElement(arr, size-1);
	}
	
	public static int smallestValueOfArray(int arr[], int size) {
		if(size == 0) {
			return arr[0];
		}
		return arr[size] < smallestValueOfArray(arr, size-1) ? arr[size] : smallestValueOfArray(arr, size-1); 
	}
	
	public static int indexOfSmallest(int arr[], int index, int smallestValue, int smallestIndex) {
		if(index >= arr.length) {
			return smallestIndex;
		}
		
		if(smallestValue > arr[index]) {
			smallestValue = arr[index];
			smallestIndex = index;
		}
		
		return indexOfSmallest(arr, index+1, smallestValue, smallestIndex);
	}
	
	public static void main(String[] args) {
		
		// scanner object
		Scanner sc = new Scanner(System.in);
		
		// prompting user for array size
		System.out.println("Enter the size of array: ");
		int size = sc.nextInt();
		
		// array declaration
		int arr[] = new int[size];
		
		// getting array elements from user
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		// printing results
		System.out.println("Using recursion----------------->");
		
		// sum of every element in the given array
		System.out.println("Sum of every element: " + sumOfEveryElement(arr, size-1));
		
		// smallest element in the given array
		System.out.println("Smallest element in the given array: " + smallestValueOfArray(arr, size-1));
		
		// index of smallest element in the given array
		System.out.println("Smallest element's index in given array: " + indexOfSmallest(arr, 0, arr[0], 0));
	}
}
