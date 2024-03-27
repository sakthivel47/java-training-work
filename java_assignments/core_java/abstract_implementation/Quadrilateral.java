package abstractimplementation;

public abstract class Quadrilateral {
	
	protected int base;
	protected int height;
	
	public Quadrilateral(int base, int height) {
		super();
		this.base = base;
		this.height = height;
	}
	
	public int getBase() {
		return base;
	}
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public abstract int area();

}
