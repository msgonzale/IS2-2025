package co.edu.uco.ucochallenge.application;

public final class Void extends Response<Object> {

	protected Void() {
		super(false, new Object());
	} 
	
	public static Void returnVoid() {
		return new Void();
		
	}

}
