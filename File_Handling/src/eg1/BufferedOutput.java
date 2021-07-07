package eg1;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutput {

	public static void main(String[] args) {
		try{    
		    FileOutputStream fin=new FileOutputStream("W:\\homework\\MyFirstFile.txt");    
		    BufferedOutputStream bin=new BufferedOutputStream(fin); 
		    try {
		    String s="ewncerkjnferwkjnvewkjnv;ewlkvn \n wvnqerkjlvnweljvewl";    
		     byte b[]=s.getBytes(); 
		     bin.write(b);
		    }
		    finally {
		    bin.close();    
		    fin.close(); 
		    }
		    
		    System.out.println("done");
		  }
		
		catch(Exception e){System.out.println(e);}   

	}

}
