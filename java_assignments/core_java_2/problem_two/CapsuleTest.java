package problemtwo;

public class CapsuleTest

{
	public static void main(String[] args) {
		int [] nInPack = {5,10,10};

		Capsule [][] pack = new Capsule[3][];

		for(int i=0;i<pack.length;i++){
			pack[i] = new Capsule[nInPack[i]];
			for(int j=0;j<pack[i].length;j++){
				pack[i][j] = new Capsule(0.5,"Formular"+i+j);
			}
		}

		System.out.println(Capsule.nCapsules); // prints 25
	}
}
