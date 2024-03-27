package stringbuffer;

import java.util.Scanner;

public class ComputeInitials {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a your full name : ");
		String str = sc.nextLine();
		
		String[] strArr = str.split("\\s");
		
		String result = new String();
		for(int i = 0; i < strArr.length; i++) {
			result = result + (strArr[i].substring(0, 1) + " ");
		}
		System.out.println(result);
		
		/*
		String result = str.substring(0, 1) +  " ";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				result = result.concat(str.substring(i+1, i+2));
			}
		}
		System.out.println(result);
		*/
		sc.close();
	}
}
