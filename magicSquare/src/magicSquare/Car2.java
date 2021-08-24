package magicSquare;

public class Car2 {

	public static void main(String[] args) {
		
		String [] dir= {"north","east","south","west"};
		
		String start="north";
		String input = "right,left,right,left,right,back,left,right,straight";
		String sa[] = input.split(",");
		int[] moves = new int[sa.length];
		
		for(int i=0;i<sa.length;i++)
		{
			if (sa[i].matches("right"))
				moves[i]=2;

			else if (sa[i].matches("left"))
				moves[i]=0;

			else if (sa[i].matches("back"))
				moves[i]=3;

			else
				moves[i]=1;                         
		}
		
	}

}
