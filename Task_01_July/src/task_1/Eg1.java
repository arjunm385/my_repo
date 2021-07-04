package task_1;

public class Eg1 {

	public static void main(String[] args) {
		
		//task 1 : use Float Long and Double wrappers 
		
		//using Float-->
		Float f1=14.001f;
		Float f2=new Float(1.0041f);
		Float f3=14.001f;
		
		// equalsTo and ==
		System.out.println("is f1==f2 ==>"+(f1==f2));
		System.out.println("is f1==f3 ==>"+(f1==f3));
		System.out.println("is f1 equals f2 ==>"+(f1.equals(f2)));
		System.out.println("is f1 equals f3 ==>"+(f1.equals(f3)));
		
		//compareTo
		System.out.println("compare f1 with smaller number: "+(f1.compareTo(1.0000000f)));
		System.out.println("compare f1 with same number: "+(f1.compareTo(f3)));
		System.out.println("compare f1 with larger number: "+(f1.compareTo(15.0022f)));
		
		String s="12000";
		
		f1=Float.parseFloat(s);
		System.out.println(f1);
		f1=5000.00f;
		System.out.println(f1);
		s=f1+"";
		System.out.println(s);
		s=f1.toString();
		System.out.println(s);
		
		//min and max values
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		
		//System.out.println(Float.toBinaryString((float)9.99));
		System.out.println(Float.toHexString((float) 99.9));
		//System.out.println(Float.toOctalString((float)11.00001));
		
		Integer i1=99;
		float f=i1.floatValue();
		System.out.println(f);
		
	}

}
