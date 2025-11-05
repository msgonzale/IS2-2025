package co.edu.uco.ucochallenge.user.registeruser.application.service;

import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.VerificationTokenEntity;
import co.edu.uco.ucochallenge.secondary.ports.repository.VerificationTokenRepository;
import org.springframework.stereotype.Service;
import java.time.*;
import java.util.*;

@Service
public class VerificationTokenService {

    private final VerificationTokenRepository repository;

    public VerificationTokenService(VerificationTokenRepository repository) {
        this.repository = repository;
    }

    public String generateEmailToken(UUID userId, Duration validity) {
        return createToken(userId, "EMAIL", validity);
    }

    public String generateSmsToken(UUID userId, Duration validity) {
        return createToken(userId, "SMS", validity);
    }

    private String createToken(UUID userId, String type, Duration validity) {
        String token = UUID.randomUUID().toString();
        VerificationTokenEntity entity = new VerificationTokenEntity();
        entity.setUserId(userId);
        entity.setToken(token);
        entity.setType(type);
        entity.setExpiresAt(Instant.now().plus(validity));
        repository.save(entity);
        return token;
    }

    public void consumeEmailToken(String token) {
        consume(token, "EMAIL");
    }

    public void consumeSmsToken(String token) {
        consume(token, "SMS");
    }

    private void consume(String token, String expectedType) {
        var entity = repository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token inválido"));

        if (!entity.getType().equals(expectedType)) throw new IllegalArgumentException("Tipo de token incorrecto");
        if (Instant.now().isAfter(entity.getExpiresAt())) throw new IllegalArgumentException("Token expirado");
        if (entity.isUsed()) throw new IllegalArgumentException("Token ya utilizado");

        entity.setUsed(true);
        repository.save(entity);
        System.out.println("[TOKEN] " + expectedType + " confirmado para usuario: " + entity.getUserId());
    }
}


