package problemtwo;

public class Capsule {
	public static int nCapsules = 0;

	public double volume;

	public String screenText;

	public Capsule(double volume,String s){
		this.volume = volume;
		screenText = s;
		nCapsules++;
	}
}
