package co.edu.uco.ucochallenge.application.interactor;

public interface Interactor<T, R> {
	R execute(T dto);
	

}
