package problemtwo;

public class SwapPosition {

	//  generic method to swap positions in any kind of list
	public static <T> T[] swap(T [] list, int firstPos, int secondPos) {

		// checking for exception when index out of bound, throws exception
		if(firstPos < 0 || firstPos >= list.length || 
				secondPos < 0 || secondPos >= list.length) {
			throw new IndexOutOfBoundsException("Invalid index! Either of the index out of bound");
		}

		T val = list[firstPos];
		list[firstPos] = list[secondPos];
		list[secondPos] = val;
		return list;
	}

	public static void main(String[] args) {


		System.out.println("*********** Integer swapping ***********");
		Integer[] intList = {10,9,11,3,7,1,73};

		System.out.println("Before swapping: ");
		for(Integer i : intList) {
			System.out.print(i + " ");
		}
		System.out.println();

		// swap function with integer list
		SwapPosition.swap(intList, 1, 5);

		System.out.println("After swapping: ");
		for(Number i : intList) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("*********** String swapping ***********");

		String[] stringList = {"Hello", "Welcome", "GoodMorning", "Bonjour", "Hola", "Namasthe"};

		System.out.println("Before swapping: ");
		for(String s : stringList) {
			System.out.print(s + " ");
		}
		System.out.println();

		// swap function with string list
		SwapPosition.swap(stringList, 1, 5);

		System.out.println("After swapping: ");
		for(String s : stringList) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}	
