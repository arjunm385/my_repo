package arrayLIST;

import java.util.ArrayList;

public class Eg1 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);

		System.out.println(list.get(1));

		for (int i = 0; i < 10; i++) {

			list.add(i);

		}
		System.out.println(list);
		list.remove(1);
		System.out.println(list);

		list.remove(Integer.valueOf(8));
		System.out.println(list);
		
		list.set(5, 1000);
		System.out.println(list);
		
		System.out.println(list.contains(1000));  //true or false

		list.clear();
		System.out.println(list); // empty list

		ArrayList<String> sl = new ArrayList<>();
		sl.add("im arjun");
		sl.add("rakesh is very nice person");
		System.out.println(sl);
		System.out.println(sl.get(1));

	}

}
