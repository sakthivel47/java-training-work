package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindIntegerFromList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the list: ");
		int size = sc.nextInt();
		
		
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter List elements");
		for(int i = 0; i < size; i++) {
			list.add(sc.nextInt());
		}
		
		System.out.println("Enter the value to find in the list: ");
		int key = sc.nextInt();
		
		boolean flag = false;
		for(int i = 0; i < size; i++) {
			if(list.get(i) == key) {
				System.out.println(key + " found at index " + i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Key not found in the given list");
		}
		sc.close();
	}
}
