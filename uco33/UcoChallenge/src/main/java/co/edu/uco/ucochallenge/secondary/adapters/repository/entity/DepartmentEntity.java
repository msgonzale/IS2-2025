package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class DepartmentEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id", nullable = false) // 👈 usa el nombre real de la columna FK en tu BD
    private CountryEntity country;

    public DepartmentEntity() {}

    public DepartmentEntity(UUID id, String nombre, CountryEntity country) {
        this.id = id;
        this.nombre = nombre;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}

