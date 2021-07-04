package task_8;

public class Remove_duplicate_char {

	public static void main(String[] args) {
	
		String r="waexiommammu sknvksnk dnvksnv kwnevknv wnfiuqehifjqeo";
		String s = r.replace(" ", "");
		String s1="";

		
		for (int i = 0; i < s.length(); i++) {
	        if(!s1.contains(String.valueOf(s.charAt(i)))) {
	            s1 += String.valueOf(s.charAt(i));
	        }
	    }
		
		System.out.println(s1);
		
	}

}
