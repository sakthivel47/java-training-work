package stringassignments;

import java.util.Scanner;

public class StringContains {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		
		String str = sc.next().toLowerCase();
		
		int digit = 0, alpha = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				alpha++;
			}
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				digit++;
			}
		}
		
		if(digit != 0 && alpha != 0) {
			System.out.println("It contains alphabets as well as digits");
		}
		else if(digit != 0) {
			System.out.println("It contains only digits");
		}
		else if(alpha != 0) {
			System.out.println("It contains only alphabets");
		}
		sc.close();
	}
}
