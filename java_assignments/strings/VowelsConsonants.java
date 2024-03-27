package stringassignments;

import java.util.Scanner;

public class VowelsConsonants {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		
		String str = sc.nextLine().toLowerCase();
		
		int vowels = 0, consonants = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
					|| str.charAt(i) == 'o' || str.charAt(i) == 'u') {
				vowels++;
			}
			else
			{
				consonants++;
			}
		}
		
		System.out.println("Total vowels in the given string: " + vowels);
		System.out.println("Total Consonants in the given string: " + consonants);
		
		sc.close();
	}
}
