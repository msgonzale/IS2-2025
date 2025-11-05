package co.edu.uco.ucochallenge.secondary.ports.repository;

import co.edu.uco.ucochallenge.secondary.adapters.repository.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends JpaRepository<CityEntity, UUID> {
    List<CityEntity> findByDepartmentId(UUID departmentId);
}
