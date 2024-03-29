package problemone;

import java.util.Scanner;

public class CountLetters {

	public static void main(String[] args) {
		int[] counts = new int[26];
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Enter a single word (letters only, please): ");
		String word = sc.nextLine().toUpperCase();
		
		try {
			for(int i = 0; i < word.length(); i++) {
				counts[word.charAt(i) - 'A']++;
			}
			for(int i = 0; i < counts.length; i++) {
				if(counts[i] != 0) {
					System.out.println((char)(i + 'A') + ": " + counts[i]);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not a letter");
			e.printStackTrace();
		}
 
		sc.close();
	}

}
