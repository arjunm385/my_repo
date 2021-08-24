package magicSquare;

import java.util.Deque;
import java.util.LinkedList;

public class UBHU {

	public static void main(String[] args) {
		
		Deque<Integer> deque = new LinkedList<>();
		int n=7;
		System.out.println(1);
		deque.add(1);
		for (int i = 2; i < n+1; i++) {
			System.out.println(i+""+deque+""+i);
			deque.addFirst(i);
			deque.addLast(i);
		}
		deque.removeFirst();
		deque.removeLast();

		for (int i = n-1; i >=2; i--) {
			deque.removeFirst();
			deque.removeLast();
			System.out.println(i+""+deque+""+i);
		}
		System.out.println(1);
	}

}
