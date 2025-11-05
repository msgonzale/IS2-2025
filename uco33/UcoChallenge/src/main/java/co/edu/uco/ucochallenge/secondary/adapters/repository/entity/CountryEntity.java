package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import java.util.UUID;

import co.edu.uco.ucochallenge.crosscuting.helper.TextHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.UUIDHelper;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class CountryEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepartmentEntity> departamentos;

    public CountryEntity() {
    	   this.id = UUIDHelper.getDefault();
           this.nombre = TextHelper.getDefault();
    }

    public CountryEntity(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = TextHelper.getDefaultWithTrim(nombre);
    }

    public List<DepartmentEntity> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartmentEntity> departamentos) {
        this.departamentos = departamentos;
    }
}
