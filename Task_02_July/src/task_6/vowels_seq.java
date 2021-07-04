package task_6;

public class vowels_seq {
public static void main(String[] args) {
	String s="waexiommammu";
	String s1="";
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < s.length(); i++) {
		
		if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') 
		{
			sb.append(s.charAt(i));
	    }
		
}
	
	for (int i = 0; i < sb.length(); i++) {
        if(!s1.contains(String.valueOf(sb.charAt(i)))) {
            s1 += String.valueOf(sb.charAt(i));
        }
    }
	
	if(s1.contains("aeiou")) {
		System.out.println("vowels are present in sequence : aeiou");
	}
}
}