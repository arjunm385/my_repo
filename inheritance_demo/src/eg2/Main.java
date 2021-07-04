package eg2;

public class Main {

	public static void main(String[] args) {

		
		Address a1=new Address(101,"Pratap Nagar","New Delhi","Delhi",110056);
		Address a2=new Address(625,"vijay nagar","patiala","Punjab",147003);
		Project p1=new Project(1000,"fedex");
		Employee e1= new Employee(11702002, "Karan", "doctor", 60000);
		e1.setProject(p1);
		e1.setPresentAddress(a1);
		e1.setPermanentAddress(a2);
		e1.print_show();

	}

}
