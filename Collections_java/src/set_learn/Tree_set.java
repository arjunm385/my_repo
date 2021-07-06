package set_learn;
import java.util.Set;
import java.util.TreeSet;
public class Tree_set {

	public static void main(String[] args) {
		Set<Integer> t = new TreeSet<>();
		
		t.add(45);
		t.add(21);
		t.add(55);
		t.add(20);
		t.add(45);
		t.add(2);
		
		System.out.println(t);
	}

}
