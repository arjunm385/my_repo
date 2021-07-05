package task_4;

public class String_prime {

	public static void main(String[] args) {

		String s = "hellooug";
		StringBuffer sb = new StringBuffer();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			count = 0;
			if (i == 0 || i == 1)
				sb.append(s.charAt(i));
			else {

				for (int j = 2; j <= i / 2; ++j) {

					if (i % j == 0) {
						count = 1;
						break;
					}
				}
				if (count == 1)
					sb.append(s.charAt(i));
				else
					sb.append(Character.toUpperCase(s.charAt(i)));
			}

		}
		System.out.println(sb.toString());
	}
}
