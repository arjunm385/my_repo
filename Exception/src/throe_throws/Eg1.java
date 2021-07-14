package throe_throws;

public class Eg1 {

	public static void main(String[] args) {	
	
	double ar = 1;
	try {
		ar = area(55.2,-9.3);
		System.out.println(ar);
	} 
	
	catch (NegativeAreaException e) {
		System.out.println(e);
	}
	
}
	
	public static double area(double a,double b) throws NegativeAreaException
	{
		if(a<0 || b<0)
			throw new NegativeAreaException();
		double c=a*b;
		return c;
	}

}
