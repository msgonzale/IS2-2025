package co.edu.uco.ucochallenge.application;

public abstract class Response<T> {
	private boolean dataReturned;
	private T data;
	
	protected Response(final boolean returnData, final T data) {
		setDataReturned(dataReturned);
		setData(data);
	}

	private void setDataReturned(boolean dataReturned) {
		//limpieza de datos
		this.dataReturned = dataReturned;
	}



	private void setData(T data) {
		//limpieza de datos
		this.data = data;
	}

	public boolean isDataReturned() {
		return dataReturned;
	}

	public T getData() {
		return data;
	}
	
}
