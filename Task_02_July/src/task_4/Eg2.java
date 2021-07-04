package task_4;

public class Eg2 {

	static void print_primes_till_N(int N, String s)
	{
		StringBuffer sb=new StringBuffer();
	    int i, j, flag=1;

	    for (i = 0; i < N; i++)
	    {
	
	        if (i == 1 || i == 0)
	        {
	        	sb.append(s.charAt(i));
	        }
	           
	 
	        for (j = 2; j <= i / 2; ++j)
	        {
	            if (i % j == 0)
	            {
	                flag = 0;
	                break;
	            }
	        }
	 
	        if (flag == 1)
	        	sb.append(Character.toUpperCase(s.charAt(i)));
	        else
	        	sb.append(s.charAt(i));
	    }
	    System.out.println(sb.toString());
	}
	 
	// Driver code
	public static void main (String[] args)
	{
	    String s="efcefcdc";
	    int N=s.length();
	    print_primes_till_N(N,s);
	}
}
