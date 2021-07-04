package task_2;

public class Eg1 {

	public static void main(String[] args) {
		
		//for bike number
		String bike="HR01X3378";
		
		if(bike != null && bike.matches("[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{4}") )
		{
			System.out.println("this is valid Vehicle number");
		}
		else
		{
			System.out.println("this is not a valid vehicle number");
		}
		
		String aad = "123456789101";
		
		if(aad != null && aad.matches("[0-9]{12}") )
		{
			System.out.println("this is valid aadhar number");
		}
		else
		{
			System.out.println("this is not a valid aadhar number");
		}
		
		
		
	}
}
