package RandD;

interface Browserme
{
	public void A();
	public void B();
	
}

class child_inter implements Browserme
{
	public void A()
	{
		System.out.println("A");
	}
	public void B()
	{
		System.out.println("B");
		
	}
	
}



public class Interfaceme {

	public static void main(String[] args) {
		
		Browserme br = new child_inter();
		br.A();
		br.B();

	}

}
