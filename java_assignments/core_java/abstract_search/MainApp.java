package assignments;

public class MainApp {
	public static void main(String[] args) {
		Integer integer1 = 1;
		Integer integer2 = 2;
		Integer integer3 = 3;
		Integer integer4 = 4;

		
		Object[] integers = new Object[4];
		integers[0] = integer1;
		integers[1] = integer2;
		integers[2] = integer3;
		integers[3] = integer4;
		
		Integer find_key = 5;
		
		IntegerSearch is = new IntegerSearch();
		if(is.search(integers, find_key)) {
			System.out.println(find_key + " found.");
		} else {
			System.out.println(find_key + " not found!");
		}
		
		String str1 = "Bill Gates";
		String str2 = "Mark Zuckerberg";
		String str3 = "Elon Musk";
		
		Object[] strings = new Object[3];
		strings[0] = str1;
		strings[1] = str2;
		strings[2] = str3;
		
		String find_str = "Bill Gates";
		StringSearch ss = new StringSearch();
		if(ss.search(strings, find_str)) {
			System.out.println(find_str + " found.");
		} else {
			System.out.println(find_str + " not found!");
		}
	}
}
