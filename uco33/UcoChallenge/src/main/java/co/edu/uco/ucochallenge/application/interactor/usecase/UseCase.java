package co.edu.uco.ucochallenge.application.interactor.usecase;

public interface UseCase<D, R>{
	R execute(D domain);
	

}
