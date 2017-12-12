package utility;

@SuppressWarnings("serial")
public class CustomException extends Exception {

	public CustomException(String errMsg) {
		super(errMsg);
		System.out.println(errMsg);
	}

}
