package co.edu.uco.ucochallenge.crosscuting.helper;


import java.util.Objects;

public final class ObjectHelper {

	private ObjectHelper() {
	}

	public static <O> boolean isNull(final O object) {
		return object == null;
	}

	public static <O> O getDefault(final O object, final O defaultValue) {
		return Objects.requireNonNullElse(object, defaultValue);
	}
	

}
