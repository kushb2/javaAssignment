package utility;

public  class StringWriter {

	private static StringBuilder builder;
	
	private StringWriter () { }
	
	
	public static StringBuilder getInstance() {
		if(builder == null){
			builder = new StringBuilder();
		}
		return builder;
	}
}
