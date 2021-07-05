package try_catch;

public class Parse_exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "arjun"; // no error with s="123"

		try {
			int a = Integer.parseInt(s);
			System.out.println(a);
		} catch (Exception e) // we can use NumberFormatException
		{
			System.out.println(e);

		}
	}
}
