package eg1;

import java.io.File;

public class File_Rename {

	public static void main(String[] args) {
		File f=new File("W:\\homework\\hello.txt");
		File r=new File("W:\\homework\\MySecondFile.txt");
		if(f.exists())
			System.out.println("file name is now renamed: "+f.renameTo(r));
		else
			System.out.println("file not exist");

	}

}
