package task_4;

public class Eg1 {
	
	public static void main(String[] args) {
		
String s="hello eceryone welcome to the world of programming";
		
		StringBuffer sb=new StringBuffer();
		String ar[]=s.split(" ");
		System.out.println("number of words in the string are --> "+ar.length);
		int length=ar.length;
		
		if(length%2==0)
		{
			System.out.println("even");
			for (int i = 0; i < ar.length; i++) {
				
			sb.append(Character.toUpperCase(ar[i].charAt(0))).append(ar[i].substring(1)).append(" ");
			}
			
			String s1=sb.toString();
		    s1=s1.trim();
			System.out.println(s1);
		}
		
		else
		{
			System.out.println("odd");
			int x,x1;
			
			for (int i = 0; i < ar.length; i++)
			{
				x=ar[i].length();
				x1=x/2;
				sb.append(ar[i].substring(0,x1)).append(Character.toUpperCase(ar[i].charAt(x1))).append(ar.clone()[i].substring((x1+1),(x))).append(" ");
			}
			String s1=sb.toString();
		    s1=s1.trim();
			System.out.println(s1);
		}
		
	}

}
