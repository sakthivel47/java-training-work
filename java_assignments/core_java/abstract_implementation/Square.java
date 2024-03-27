package abstractimplementation;

class Square extends Quadrilateral {
	
	public Square(int base) {
		super(base, base);
	}

	@Override
	public int area() {
		return base * base;
	}
	
}
