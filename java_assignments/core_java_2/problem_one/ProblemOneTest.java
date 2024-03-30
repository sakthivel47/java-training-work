package problemone;

public class ProblemOneTest

{

	public static void main(String[] args)

	{

		ProblemOne instanceA = new ProblemOne();

		ProblemOne instanceB = new ProblemOne();

		instanceA.a = 8;

		instanceB.b = instanceA.x;

		instanceA.x++;

		instanceB.a = 10;

		instanceB.c = 90;

		instanceB.x++;
		
		System.out.println(instanceA); // instanceA.a = 8, instanceA.b = 0, instanceA.c = 2
		
		System.out.println(instanceB); // instanceB.a = 10, instanceB.b = 6, instanceB.c = 90
		
		// value of static variable x = 8
	}

}