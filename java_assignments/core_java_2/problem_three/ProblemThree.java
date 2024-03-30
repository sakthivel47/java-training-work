package problemthree;

public class ProblemThree {
	
	public ProblemThree() {
		this(0);
		System.out.println("A");
	}

	public ProblemThree(int k){
		this(0,0);
		System.out.println("B");
	}

	public ProblemThree(int k,int m){
		System.out.println("C");
	}

}