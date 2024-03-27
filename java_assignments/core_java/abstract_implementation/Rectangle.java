package abstractimplementation;

class Rectangle extends Quadrilateral {

	public Rectangle(int base, int height) {
		super(base, height);
	}

	@Override
	public int area() {
		return base * height;
	}
}