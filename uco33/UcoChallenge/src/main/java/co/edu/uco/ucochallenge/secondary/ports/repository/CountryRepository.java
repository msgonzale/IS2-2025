package co.edu.uco.ucochallenge.secondary.ports.repository;

import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {}

