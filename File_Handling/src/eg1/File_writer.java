package eg1;

import java.io.FileWriter;
import java.io.IOException;

public class File_writer {

	public static void main(String[] args) {
try {
FileWriter f=new FileWriter("W:\\homework\\MyFirstFile.txt"); //it will automatically create a new file if no file exists in the memory
try {
	f.write("java is the best programming language");
	f.write("\njava is the best programming language");
}
finally {
	f.close();
}
System.out.println("write operation successful");
}
catch(IOException i) {
	System.out.println(i);
}

	}

}
//all data will be replaced 
//if you have any previous data thrn it will be removed