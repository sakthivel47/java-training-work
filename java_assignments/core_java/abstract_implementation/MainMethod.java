package abstractimplementation;

public class MainMethod {

	public static void main(String[] args) {
//		Quadrilateral foursides = new Quadrilateral(10, 20);
		
		// Can a Square be modeled as Rectangle
		
		Quadrilateral square = new Square(4);
		System.out.println(square.area());
		
		Quadrilateral rectangle = new Rectangle(4, 4);
		System.out.println(rectangle.area());
	}

}
