package co.edu.uco.parametersservice.catalog;

import java.util.HashMap;
import java.util.Map;

public final class ParameterCatalog {

	private static Map<String, Parameter> parameters = new HashMap<>();
	
	private ParameterCatalog() {
	}

	static {
		parameters.put("FechaDefectoMaxima", new Parameter("FechaDefectoMaxima","31/12/2500"));
		parameters.put("correoAdministrador", new Parameter("correoAdministrador","admin@uco.edu.co"));
		parameters.put("numeroMaximoReintentosEnvioCorreo", new Parameter("numeroMaximoReintentosEnvioCorreo","8"));
	}
	
	public static Parameter getParameterValue(String key) {
		return parameters.get(key);
	}
	
	public static void synchronizeParameter(Parameter parameter) {
		parameters.put(parameter.getKey(),parameter);
	}
	
	public static void removeParameter(String key) {
		 parameters.remove(key);
	}
	public static Map<String, Parameter> getAllParameters() {
		return parameters;
	}

}
