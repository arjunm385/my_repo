package eg1;

import java.io.FileReader;
import java.io.IOException;

public class File_reader {

	public static void main(String[] args) {
	try {
		FileReader r = new FileReader("W:\\homework\\MyFirstFile.txt"); //it will not create any new file
		try {
			int i;
			while((i=r.read())!=-1)
					{
				System.out.println((char)i);
					}
			
		}
		finally {
			r.close();
		}
	}
	catch(IOException i) {
		System.out.println(i);
	}

	}

}
