package task_3;

public class Odd_evev {
	
	public static void main(String[] args) {
		
		int ar[]= {12,22,14,55,74,88,65,1,8};
		double even_sum=0,even_count=0;
		double odd_sum=0,odd_count=0;
		System.out.println("numbers are :");
		for (int x : ar) {
			System.out.println(x);
		}
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]%2==0)
			{
				even_sum+=ar[i];
				even_count++;
			}
			else
			{
				odd_sum+=ar[i];
				odd_count++;
			}
		}
		
		double even_avg=even_sum/even_count;
		double odd_avg=odd_sum/odd_count;

		System.out.println("average of even numbers are :"+even_avg);
		System.out.println("average of odd numbers are :"+odd_avg);
	}

}
