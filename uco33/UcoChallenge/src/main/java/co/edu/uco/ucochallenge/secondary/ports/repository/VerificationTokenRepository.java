package co.edu.uco.ucochallenge.secondary.ports.repository;

import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, UUID> {
    Optional<VerificationTokenEntity> findByToken(String token);
}
