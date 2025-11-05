package co.edu.uco.ucochallenge.primary.controller;

import co.edu.uco.ucochallenge.user.registeruser.application.interactor.RegisterUserInteractor;
import co.edu.uco.ucochallenge.user.registeruser.application.interactor.dto.RegisterUserInputDTO;
import co.edu.uco.ucochallenge.user.registeruser.application.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "")

@RestController
@RequestMapping("/uco-challenge/api/v1/users")
public class UserController {

    private final RegisterUserInteractor registerUserInteractor;
    private final UserRegistrationService registrationService;

    public UserController(RegisterUserInteractor registerUserInteractor,
                          UserRegistrationService registrationService) {
        this.registerUserInteractor = registerUserInteractor;
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserInputDTO dto,
                                          @RequestHeader(value = "X-Actor", required = false) String actor) {

        var normalizedDto = RegisterUserInputDTO.normalize(
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

        registerUserInteractor.execute(normalizedDto);
        return new ResponseEntity<>(Map.of("message", "Usuario registrado exitosamente"), HttpStatus.CREATED);
    }


    @PostMapping("/confirm/email/{token}")
    public ResponseEntity<?> confirmEmail(@PathVariable String token) {
        registrationService.confirmEmail(token);
        return ResponseEntity.ok(Map.of("status", "email_confirmed"));
    }


    @PostMapping("/confirm/sms/{token}")
    public ResponseEntity<?> confirmSms(@PathVariable String token) {
        registrationService.confirmSms(token);
        return ResponseEntity.ok(Map.of("status", "mobile_confirmed"));
    }
}

