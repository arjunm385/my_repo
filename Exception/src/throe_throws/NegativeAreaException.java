package throe_throws;

@SuppressWarnings("serial")
public class NegativeAreaException extends Exception{
	
	@Override
	public String toString() {
		return "length or breadth cannot be nagative";
	}
	
	@Override
	public String getMessage() {
	return "length or breadth cannot be nagative";
	}

}
