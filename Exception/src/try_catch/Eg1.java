package try_catch;

public class Eg1 {

	public static void main(String[] args) {
		int a = 10, b = 0, c = 0;
		try {
			c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			System.out.println("error occured");
			System.out.println(e);
		}
	}

}
