package problemfour;

import java.util.Random;

public class MyIntArrayUtil {
	public static void main(String[] args) {
		
		// declaring variable with size 10
		int size = 10;
		
		// array declaration
		int arr[] = new int[size];
		
		// creating an instance of Random()
		Random random = new Random();
		
		// filling the array with random values in range (0, 100)
		for(int i = 0; i < size; i++) {
			arr[i] = random.nextInt(100+1);
		}
		
		// printing array before sorting
		System.out.println("Array before sorting: ");
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
		// function call for array sorting
		sortArray(arr, size);
		
		
		// printing array after sorting
		System.out.println("Array after sorting");
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
	
	// sorting using bubble sort method
	public static void sortArray(int arr[], int size) {
		for(int i = 0; i < size - 1; i++) {
			for(int j = i+1; j < size; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
