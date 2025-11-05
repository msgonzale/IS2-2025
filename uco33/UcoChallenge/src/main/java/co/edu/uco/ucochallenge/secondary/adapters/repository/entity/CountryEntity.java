package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import java.util.UUID;


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

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StateEntity> states;


    public CountryEntity() {

    }

    public CountryEntity(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public List<StateEntity> getStates() {
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
}
