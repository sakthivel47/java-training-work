package stringassignments;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		
		String str = sc.nextLine();
		
		System.out.println("String recursion using iterative method");
		System.out.println(reverseIterative(str));
		
		System.out.println("String recursion using recursive method");
		System.out.println(reverseRecursive(str));
		
		sc.close();
		
		
	}
	
	public static String reverseIterative(String str) {	
		int j = str.length()-1;
		char res[] = new char[j+1];
		for(int i = 0; i < str.length(); i++) {
			res[i] = str.charAt(j);
			j--;
		}
		return new String(res);
	}
	
	public static String reverseRecursive(String str) {
		if(str.isEmpty()) {
			return str;
		}
		else {
			return reverseRecursive(str.substring(1))+str.charAt(0);
		}
	}
}

