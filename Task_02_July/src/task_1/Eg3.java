package task_1;

public class Eg3 {

	public static void main(String[] args) {
		String s = new String();
		int ar[] = { 12221, 15612, 6216, 16161, 16161, 6216161, 151515151 };

		for (int i = 0; i < ar.length; i++) {
			s = (ar[i] + "");
			palindrome(s);
		}
	}

	public static void palindrome(String s) {
		if (new StringBuffer(s).reverse().toString().equals(s)) {
			System.out.println("palindrome :" + s);
		}
	}
}