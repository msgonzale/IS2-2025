package co.edu.uco.ucochallenge.crosscuting.helper;

import java.util.UUID;

public final class UUIDHelper {

	private UUIDHelper() {
		super();
	}

	public static UUID getDefault() {
		return new UUID(0L, 0L);
	}

	public static UUID getDefault(final UUID value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

	public static UUID getFromString(final String uuidAsString) {
		return TextHelper.isEmpty(uuidAsString) ? getDefault() : UUID.fromString(uuidAsString);
	}
}