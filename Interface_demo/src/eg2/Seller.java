package eg2;

public class Seller implements Customer {
	
	@Override
	public void price() {
		System.out.println("the price for : "+qty+" peices is equals to -----/-");
	}

}
