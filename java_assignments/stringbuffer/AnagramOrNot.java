package stringbuffer;

import java.util.Scanner;

public class AnagramOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1: ");
		String str1 = sc.nextLine().toLowerCase();
		
		System.out.println("Enter String 2: ");
		String str2 = sc.nextLine().toLowerCase();
		
		if(str1.length() != str2.length()) {
			System.out.println("Given string is not a anagram");
		} else {
			int freq[] = new int[26];
			
			for(int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
					freq[str1.charAt(i) - 97]++;
				}
			}
			
			for(int i = 0; i < str2.length(); i++) {
				if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') { 
					freq[str2.charAt(i) - 97]--;
				}
			}
			boolean check = false;
			
			for(int i = 0; i < freq.length; i++) {
				if(freq[i] != 0) {
					check = true;
				}
			}
			
			if(check) {
				System.out.println("Given string is not a anagram");
			} else {
				System.out.println("Given string is a anagram");
			}
		}
		
		sc.close();
	}
}
