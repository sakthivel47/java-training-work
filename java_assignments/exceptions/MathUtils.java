package problemthree;

public class MathUtils {
	public static int factorial(int n) throws IllegalArgumentException {
		int fac = 1;
		if(n < 0 ) {
			throw new IllegalArgumentException("Negative value not applicable");
		}
		if(n > 16) {
			throw new IllegalArgumentException("Enter value less than 16");
		}
		for(int i = n; i > 0; i--) {
			fac *= i;
		}
		return fac;
	}
}
