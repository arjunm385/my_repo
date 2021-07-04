package task_7;
import java.util.HashSet;
import java.util.Set;
public class Duplicates {
public static void main(String[] args) {
	
	int ar[]= {11,11,22,22,13,12,13,13,12};
	Set<String> hs=new HashSet<>();
	
   for (int i = 0; i < ar.length; i++) {
	   
	   hs.add(""+ar[i]);
	
}

   System.out.println(hs);
	
}
}
