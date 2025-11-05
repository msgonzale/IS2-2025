package co.edu.uco.ucochallenge.user.registeruser.application.interactor.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucochallenge.application.Void;
import co.edu.uco.ucochallenge.user.registeruser.application.interactor.RegisterUserInteractor;
import co.edu.uco.ucochallenge.user.registeruser.application.interactor.dto.RegisterUserInputDTO;
import co.edu.uco.ucochallenge.user.registeruser.application.interactor.usecase.RegisterUserUseCase;
import co.edu.uco.ucochallenge.user.registeruser.application.usecase.domain.RegisterUserDomain;

@Service
@Transactional
public class RegisterUserInteractorImpl implements RegisterUserInteractor {

    private final RegisterUserUseCase useCase;

    public RegisterUserInteractorImpl(RegisterUserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(final RegisterUserInputDTO dto) {


        RegisterUserDomain registerUserDomain = new RegisterUserDomain(
            dto.idType(),
            dto.idNumber(),
            dto.firstName(),
            dto.secondName(),
            dto.firstSurname(),
            dto.secondSurname(),
            dto.homeCity(),
            dto.email(),
            dto.mobileNumber()
        );

   
        return useCase.execute(registerUserDomain);
    }
}

