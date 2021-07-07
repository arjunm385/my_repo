package eg1;

import java.io.File;
import java.io.IOException;

public class File_Creation {

	public static void main(String[] args) {
	File f = new File("W:\\homework\\MyFirstFile.txt");
	
	try {
		if(f.createNewFile())
			System.out.println("file successfully created");
		else
			System.out.println("file already exist");
	}
	catch(IOException e)
	{
		System.out.println("error occured"+e);
	}

	}

}
