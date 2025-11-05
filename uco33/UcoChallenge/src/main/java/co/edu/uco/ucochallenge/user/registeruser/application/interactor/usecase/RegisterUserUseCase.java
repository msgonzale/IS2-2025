package co.edu.uco.ucochallenge.user.registeruser.application.interactor.usecase;

import co.edu.uco.ucochallenge.application.Void;
import co.edu.uco.ucochallenge.user.registeruser.application.usecase.domain.RegisterUserDomain;

public interface RegisterUserUseCase {
    Void execute(RegisterUserDomain domain);
}
