package magicSquare;

public class StringProblem {

	public static void main(String[] args) {
		
		String s="AaV1&Bb2Gg%3;*";
		int count1=0;
		int count2=0;
		int count3=0;
		
		for(int i=0;i<s.length();i++)
		{
			if(s.substring(i,i+1).matches("[1-9]")) {
				count1++;
			}
			if(s.substring(i,i+1).matches("[A-Z]")) {
				count2++;
			}
			if(s.substring(i,i+1).matches("[a-z]")) {
				count3++;
		    }
					
		}
		
System.out.println("count of numbers is: "+count1);
System.out.println("count of Uppercase is: "+count2);
System.out.println("count of lowecase is: "+count3);
System.out.println("count of special characters is: "+(s.length()-count1-count2-count3));


	}

}
