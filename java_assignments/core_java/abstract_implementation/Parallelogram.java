package abstractimplementation;

class Parallelogram extends Quadrilateral {

	public Parallelogram(int base, int height) {
		super(base, height);
	}

	@Override
	public int area() {
		return base * height;
	}
	
}