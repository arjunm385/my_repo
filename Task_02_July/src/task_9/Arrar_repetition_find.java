package task_9;

public class Arrar_repetition_find {

	public static void main(String[] args) {

		int ar[] = { 1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 5, 5, 8, 8, 9, 9, 9 };
		int max = 0, count, max_rep = 0;

		for (int i = 0; i < ar.length; i++) {
			count = 1;
			for (int j = i + 1; j < ar.length; j++) {

				if (ar[i] == ar[j]) {
					count++;
					if (count > max) {
						max = count;
						max_rep = ar[i];
					}
				}

			}
		}
		System.out.println(max_rep);

	}

}
