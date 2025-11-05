package co.edu.uco.ucochallenge.user.registeruser.application.interactor.usecase.impl;

import org.springframework.stereotype.Service;
import co.edu.uco.ucochallenge.application.Void;
import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.UserEntity;
import co.edu.uco.ucochallenge.secondary.ports.repository.UserRepository;
import co.edu.uco.ucochallenge.user.registeruser.application.interactor.usecase.RegisterUserUseCase;
import co.edu.uco.ucochallenge.user.registeruser.application.usecase.domain.RegisterUserDomain;

@Service
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
	
	private UserRepository repository;
	
	
	public RegisterUserUseCaseImpl(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public Void execute(final RegisterUserDomain domain) {
		// Data Mapping/Map struct
		UserEntity userEntity = null;
		repository.save(userEntity);
		return Void.returnVoid();
	}

}
