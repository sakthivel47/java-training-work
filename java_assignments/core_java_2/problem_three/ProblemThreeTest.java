package problemthree;

public class ProblemThreeTest

{
	public static void main(String[] args) { 
		int k = 5, j = 6;
		
		ProblemThree a = new ProblemThree();
		ProblemThree b = new ProblemThree(k*j);
		ProblemThree c = new ProblemThree(k,j);
		
		// this is an example of "calling the constructor of base class using super keyword"
		
		/* Output 
		    C
			B
			A
			C
			B
			C
		*/
		
	}
}