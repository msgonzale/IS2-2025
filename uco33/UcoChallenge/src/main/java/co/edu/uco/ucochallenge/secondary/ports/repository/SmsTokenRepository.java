package co.edu.uco.ucochallenge.secondary.ports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.SmsTokenEntity;

public interface SmsTokenRepository extends JpaRepository<SmsTokenEntity, String> { }

