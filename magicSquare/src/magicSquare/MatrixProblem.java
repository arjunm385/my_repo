package magicSquare;

public class MatrixProblem {

	public static void main(String[] args) {
		
int[][] arr={{0,    0,	0,	0,	0,	0,	0,	0,	0},
		     {0,	0,	0,	0,	0,	0,	0,	0,	0},
		     {0,	0,	1,	1,	1,	0,	0,	0,	0},
		     {0,	0,	1,	1,	1,	0,	0,	0	,0},
		     {0,	0,	1,	1,	1,	0,	0,	0,	0},
		     {0,	0,	0,	0,	0,	0,	0,	0,	0},
		     {0,	0,	0,	0,	0,	0,	0,	0,	0},
		     {0,	0,	0,	0,	0,	0,	0,	0,	0},
		     {0,	0,	0,	0,	0,	0,	0,	0,	0}};

	
int starti=0,startj=0;
int endi=0,endj=0;
int flag=0;

		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(arr[i][j]==1)
				{
					starti=i;
					startj=j;
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		
		flag=0;
		
		for(int i=8;i>=0;i--)
		{
			for(int j=8;j>=0;j--)
			{
				if(arr[i][j]==1)
				{
					endi=i;
					endj=j;
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		flag=0;
		for(int i=starti;i<=endi;i++)
		{
			for(int j=startj;j<=endj;j++)
			{
				if(arr[i][j]==0)
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
	if(flag==1)
		System.out.println("not a perfect square");
	
	
	else
	{
		flag=0;
		for(int i=0;i<starti;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(arr[i][j]==1)
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==1)
			System.out.println("not a perfect square");
		else
		{
			flag=0;
			for(int i=endi+1;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(arr[i][j]==1)
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			if(flag==1)
				System.out.println("not a perfect square");
			
			else
			{
				flag=0;
				for(int i=0;i<9;i++)
				{
					for(int j=0;j<startj;j++)
					{
						if(arr[i][j]==1)
						{
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
				if(flag==1)
					System.out.println("not a perfect square");
				else {
					flag=0;
					for(int i=0;i<9;i++)
					{
						for(int j=endj+1;j<9;j++)
						{
							if(arr[i][j]==1)
							{
								flag=1;
								break;
							}
						}
						if(flag==1)
							break;
					}
					if(flag==1)
						System.out.println("not a perfect square");
					else
						System.out.println("perfect square");
				}
			}
		}
		
		
	}
		

	}

}
