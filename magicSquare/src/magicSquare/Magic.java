package magicSquare;
public class Magic {

	public static void main(String[] args) {
		
		int[][] arr=new int[5][5];

		int i=2;
		int j=2;
		int ele=1;
		int flag=0;
		
		do
		{
			flag=0;
				if(j>=5)
					j=0;
				if(i<0)
					i=4;
				if(j<0)
					j=4;
				if(i>=5)
					i=i-5;
				
			
			if(arr[i][j]!=0 )
			{

//				i=i+3;
//				j=j-2
//				continue;
				i=i+2;
				j--;
				flag=1;
			}
			else {
				arr[i][j]=ele;
				ele++;
			}
			
			if(flag==0)
		{
			j++;
			i--;
		}
			
		}while(ele!=26);
		
		
		for( i=0;i<5;i++)
		{
			for( j=0;j<5;j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println("");
		}
	}

}
