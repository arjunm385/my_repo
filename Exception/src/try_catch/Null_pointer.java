package try_catch;

public class Null_pointer {

	public static void main(String[] args) {
		
		String s=null;
		try {
		System.out.println(s.toUpperCase());
		}
		catch(NullPointerException e) //we can use Exception in the place of NullPointerException
		{
			System.out.println("opps an error occured : "+e);
		}
	}

}
