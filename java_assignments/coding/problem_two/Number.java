package problemone;

import java.util.Scanner;

public class Number {
	
	public static boolean checkPrime(int x) {
		for(int i = 2; i < x; i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkAmstrong(int x) {
		int num = x, sum = 0;
		int digits = (int) (Math.log10(x) + 1);
		while(x > 0) {
			int res = x % 10;
			sum += (Math.pow(res, digits));
			x /= 10;
		}
		return num == sum ? true : false;
	}
	
	public static boolean checkPalindrome(int x) {
		int num = x, rev = 0;
		while(x > 0) {
			int res = x % 10;
			rev = rev * 10 + res;
			x /= 10;
		}
		return num == rev ? true : false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char run = 'y';
		do {
			
			System.out.print(""
					+ "1. Check Prime or not\n"
					+ "2. Check Amstrong or not\n"
					+ "3. Check Palindrome or not\n"
					+ "Enter your choice: ");
			
			int number = 0;
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.print("Enter a number: ");
				number = sc.nextInt();
				if(Number.checkPrime(number)) {
					System.out.println(number + " is a prime number.");
				} else {
					System.out.println(number + " is not a prime number.");
				}
				break;
			
			case 2:
				System.out.print("Enter a number: ");
				number = sc.nextInt();
				if(Number.checkAmstrong(number)) {
					System.out.println(number + " is a amstrong number.");
				} else {
					System.out.println(number + " is not a amstrong number.");
				}
				break;
				
			case 3:
				System.out.print("Enter a number: ");
				number = sc.nextInt();
				if(Number.checkPalindrome(number)) {
					System.out.println(number + " is a palindrome number.");
				} else {
					System.out.println(number + " is not a palindrome number.");
				}
				break;
				
			default:
				System.out.println("Not a valid option!");
			}
			
			System.out.print("Do you want to continue? (y/N) ");
			run = sc.next().charAt(0);
			
		}while(run == 'y' || run == 'Y');
		sc.close();
	}
}
