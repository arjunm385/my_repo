package eg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_File {

	public static void main(String[] args) throws IOException,FileNotFoundException {
	
		FileInputStream f=new FileInputStream("W:\\homework\\MyFirstFile.txt");
		FileOutputStream r= new FileOutputStream("W:\\homework\\MySecondFile.txt");
		int i;
		while((i=f.read())!=-1) {
			r.write(i);
		}
System.out.println("data copied");

r.close();
f.close();
	}

}
