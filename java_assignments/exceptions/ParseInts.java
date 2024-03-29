package problemtwo;

import java.util.Scanner;

public class ParseInts {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a line: ");

		String line = sc.nextLine();

		String[] separated = line.split(" ");

		int sum = 0, num = 0;

		for(String str : separated) {
			try {
				num = Integer.parseInt(str);
				sum += num;
			} catch(NumberFormatException e) {

			}
		}

		System.out.println("The sum of integers on the line is " + sum + ".");
		
		sc.close();
	}
}
