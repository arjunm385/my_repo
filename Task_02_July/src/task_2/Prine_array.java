package task_2;

public class Prine_array {

	public static void main(String[] args) {
		int a[] = { 5, 2, 10, 20, 1, 3, 11, 13, 1, 21, 22, 14 };
		int count = 0;

		for (int i = 0; i < a.length; i++) {

			count = 0;
			if (a[i] == 0 || a[i] == 1)
				System.out.println(a[i] + " is not a prime number.");
			else {
				for (int j = 2; j <= a[i] / 2; j++) {

					if (a[i] % j == 0) {
						count = 1;
						break;
					}

				}

				if (count == 1)
					System.out.println(a[i] + " is not a prime number.");

				else
					System.out.println(a[i] + " is a prime number.");
			}

		}
	}

}
