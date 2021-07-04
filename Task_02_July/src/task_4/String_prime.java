package task_4;

public class String_prime {

	public static void main(String[] args) {

		String s = "hellooug";
		StringBuffer sb = new StringBuffer();
		boolean flag = false;

		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i == 1)
				sb.append(s.charAt(i));
			else {

				for (int j = 2; j <= i / 2; ++j) {

					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (flag == true)
					sb.append(s.charAt(i));
				else
					sb.append(Character.toUpperCase(s.charAt(i)));
			}

		}
		System.out.println(sb.toString());
	}
}
