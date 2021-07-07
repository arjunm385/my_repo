package eg1;

import java.io.File;

public class File_Info {

	public static void main(String[] args) {
		
		File f=new File("W:\\homework\\MyFirstFile.txt");
		
		if(f.exists())
		{
			System.out.println("File Name: "+f.getName());
			System.out.println("File path: "+f.getAbsolutePath());
			System.out.println("File size: "+f.length());
			System.out.println("File readable: "+f.canRead());
			System.out.println("File writable: "+f.canWrite());
		  //System.out.println("File removed: "+f.delete());
		}
		else
			System.out.println("file does not exist");

	}

}
