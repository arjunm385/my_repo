package task_3;

public class Eg2 {

	public static void main(String[] args) {
		
		String s="hello eceryone welcome to the world of programming";
		
		StringBuffer sb=new StringBuffer();
		String ar[]=s.split(" ");
	for (int i = 0; i < ar.length; i++)
	{
		sb.append(ar[i].substring(0, (ar[i].length()-1))).append(Character.toUpperCase(ar[i].charAt(ar[i].length()-1))).append(" ");
		
	}
	    String s1=sb.toString();
	    s1=s1.trim();
		System.out.println(s1);
		
		
	}
	
}
