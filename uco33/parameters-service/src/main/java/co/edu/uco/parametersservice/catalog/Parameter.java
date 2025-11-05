package co.edu.uco.parametersservice.catalog;

public class Parameter {
	
	private String key;
	private String value;
	
	public Parameter(String key, String value) {
		
		setKey(key);
		setValue(value);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
