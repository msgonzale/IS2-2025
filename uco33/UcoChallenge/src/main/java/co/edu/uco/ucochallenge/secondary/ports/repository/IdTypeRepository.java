package co.edu.uco.ucochallenge.secondary.ports.repository;

import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.IdTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdTypeRepository extends JpaRepository<IdTypeEntity, UUID> {}
