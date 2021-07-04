package task_2;

public class Prime_no {

	public static void main(String[] args) {

		int ar[] = { 5, 2, 10, 20, 1, 3 };
		boolean flag = false;
		for (int j = 0; j < ar.length; j++) {

			if (ar[j] == 0 || ar[j] == 1)
				System.out.println(ar[j] + " is not a prime number.");
			else {
				for (int i = 2; i <= ar[j] / 2; ++i) {

					if (ar[j] % i == 0) {
						flag = true;
						break;
					}
				}
				if (!flag)
					System.out.println(ar[j] + " is a prime number.");
				else
					System.out.println(ar[j] + " is not a prime number.");
			}
		}

	}

}
