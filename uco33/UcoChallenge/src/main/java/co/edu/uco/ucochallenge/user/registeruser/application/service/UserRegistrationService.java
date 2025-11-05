package co.edu.uco.ucochallenge.user.registeruser.application.service;

import co.edu.uco.ucochallenge.secondary.ports.repository.UserRepository;
import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.UUID;

@Service
public class UserRegistrationService {

    private final UserRepository repo;
    private final VerificationTokenService tokenService;
    private final NotificationService notification;

    public UserRegistrationService(UserRepository repo,
                                   VerificationTokenService tokenService,
                                   NotificationService notification) {
        this.repo = repo;
        this.tokenService = tokenService;
        this.notification = notification;
    }

    @Transactional
    public UUID register(UserEntity incoming, String ejecutor) {
        if (incoming.getId() == null) {
            incoming.setId(UUID.randomUUID());
        }

        repo.findByEmail(incoming.getEmail()).ifPresent(existing -> {
            notification.notifyActor(ejecutor, "Ya existe un usuario con el email: " + incoming.getEmail());
            notification.notifyOwnerEmail(existing.getEmail(), "Se intentó registrar otro usuario con tu email.");
            throw new BusinessRuleException("Email ya registrado");
        });

        if (incoming.getMobileNumber() != null) {
            repo.findByMobileNumber(incoming.getMobileNumber()).ifPresent(existing -> {
                notification.notifyActor(ejecutor, "Ya existe un usuario con el número: " + incoming.getMobileNumber());
                notification.notifyOwnerSms(existing.getMobileNumber(), "Se intentó registrar otro usuario con tu número.");
                throw new BusinessRuleException("Número móvil ya registrado");
            });
        }

        repo.findByIdTypeAndIdNumber(incoming.getIdType(), incoming.getIdNumber()).ifPresent(existing -> {
            notification.notifyActor(ejecutor, "Ya existe un usuario con el mismo tipo y número de identificación.");
            notification.notifyAdmin("Doble identificación detectada: tipo=" + incoming.getIdType() +
                    ", número=" + incoming.getIdNumber());
            throw new BusinessRuleException("Identificación ya registrada");
        });

        UserEntity saved = repo.save(incoming);

        var emailToken = tokenService.generateEmailToken(saved.getId(), Duration.ofMinutes(10));
        notification.sendEmailVerification(saved.getEmail(), emailToken);

        if (saved.getMobileNumber() != null) {
            var smsToken = tokenService.generateSmsToken(saved.getId(), Duration.ofMinutes(10));
            notification.sendSmsVerification(saved.getMobileNumber(), smsToken);
        }

        notification.notifyActor(ejecutor, "Usuario registrado. Se enviaron confirmaciones.");
        return saved.getId();
    }

    @Transactional
    public void confirmEmail(String token) {
        tokenService.consumeEmailToken(token);
    }

    @Transactional
    public void confirmSms(String token) {
        tokenService.consumeSmsToken(token);
    }

    public static class BusinessRuleException extends RuntimeException {
        public BusinessRuleException(String msg) { super(msg); }
    }
}

