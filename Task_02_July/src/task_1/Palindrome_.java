package task_1;

public class Palindrome_ {

	public static void main(String[] args) {

		String s = "12221 156126216 16161 16161 6216161 navan kavan kanak madam";

		StringBuffer sb = new StringBuffer();
		String ar[] = s.split(" ");
		System.out.println(s);
		int count = 0;

		for (int i = 0; i < ar.length; i++) {
			sb.append(ar[i]);
			if (sb.reverse().toString().equals(ar[i])) {
				System.out.println("\npalindrome :" + sb.toString());
				count++;
			}
			sb.delete(0, sb.length());
		}
		System.out.println("\ntotal palindrome are : " + count);
	}
}