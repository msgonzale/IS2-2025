package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import java.util.UUID;

import co.edu.uco.ucochallenge.crosscuting.helper.ObjectHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.TextHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.UUIDHelper;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class UserEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "tipoIdentificacion")
    private IdTypeEntity idType;

    @Column(name = "numeroIdentificacion")
    private String idNumber;

    @Column(name = "primerNombre")
    private String firstName;

    @Column(name = "segundoNombre")
    private String secondName;

    @Column(name = "primerApellido")
    private String firstSurname;

    @Column(name = "segundoApellido")
    private String secondSurname;

    @ManyToOne
    @JoinColumn(name = "ciudadResidencia")
    private CityEntity homeCity;

    @Column(name = "email")
    private String email;

    @Column(name = "telefonoMovil")
    private String mobileNumber;

    @Column(name = "emailConfirmado")
    private boolean emailConfirmed;

    @Column(name = "telefonoMovilConfirmado")
    private boolean mobileNumberConfirmed;

    private boolean emailConfirmedIsDefaultValue;
    private boolean mobileNumberConfirmedIsDefaultValue;

    protected UserEntity() {
        setId(UUIDHelper.getDefault());
        setIdType(new IdTypeEntity());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(new CityEntity());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobileNumberConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    // --- Constructor Builder ---
    private UserEntity(final Builder builder) {
        setId(builder.id);
        setIdType(builder.idType);
        setIdNumber(builder.idNumber);
        setFirstName(builder.firstName);
        setSecondName(builder.secondName);
        setFirstSurname(builder.firstSurname);
        setSecondSurname(builder.secondSurname);
        setHomeCity(builder.homeCity);
        setEmail(builder.email);
        setMobileNumber(builder.mobileNumber);
        setEmailConfirmed(builder.emailConfirmed);
        setMobileNumberConfirmed(builder.mobileNumberConfirmed);
        setEmailConfirmedIsDefaultValue(builder.emailConfirmedIsDefaultValue);
        setMobileNumberConfirmedIsDefaultValue(builder.mobileNumberConfirmedIsDefaultValue);
    }

    // --- Builder ---
    public static final class Builder {
        private UUID id;
        private IdTypeEntity idType;
        private String idNumber;
        private String firstName;
        private String secondName;
        private String firstSurname;
        private String secondSurname;
        private CityEntity homeCity;
        private String email;
        private String mobileNumber;
        private boolean emailConfirmed;
        private boolean mobileNumberConfirmed;
        private boolean emailConfirmedIsDefaultValue = true;
        private boolean mobileNumberConfirmedIsDefaultValue = true;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder idType(final IdTypeEntity idType) { this.idType = idType; return this; }
        public Builder idNumber(final String idNumber) { this.idNumber = idNumber; return this; }
        public Builder firstName(final String firstName) { this.firstName = firstName; return this; }
        public Builder secondName(final String secondName) { this.secondName = secondName; return this; }
        public Builder firstSurname(final String firstSurname) { this.firstSurname = firstSurname; return this; }
        public Builder secondSurname(final String secondSurname) { this.secondSurname = secondSurname; return this; }
        public Builder homeCity(final CityEntity homeCity) { this.homeCity = homeCity; return this; }
        public Builder email(final String email) { this.email = email; return this; }
        public Builder mobileNumber(final String mobileNumber) { this.mobileNumber = mobileNumber; return this; }
        public Builder emailConfirmed(final boolean emailConfirmed) {
            this.emailConfirmed = emailConfirmed;
            this.emailConfirmedIsDefaultValue = false;
            return this;
        }
        public Builder mobileNumberConfirmed(final boolean mobileNumberConfirmed) {
            this.mobileNumberConfirmed = mobileNumberConfirmed;
            this.mobileNumberConfirmedIsDefaultValue = false;
            return this;
        }
        public UserEntity build() { return new UserEntity(this); }
    }

    // --- Getters ---
    public UUID getId() { return id; }
    public IdTypeEntity getIdType() { return idType; }
    public String getIdNumber() { return idNumber; }
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public String getFirstSurname() { return firstSurname; }
    public String getSecondSurname() { return secondSurname; }
    public CityEntity getHomeCity() { return homeCity; }
    public String getEmail() { return email; }
    public String getMobileNumber() { return mobileNumber; }
    public boolean isEmailConfirmed() { return emailConfirmed; }
    public boolean isMobileNumberConfirmed() { return mobileNumberConfirmed; }

    // --- Setters (solo cambió este a PUBLIC) ---
    public void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }

    private void setIdType(final IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, new IdTypeEntity());
    }

    private void setIdNumber(final String idNumber) {
        this.idNumber = TextHelper.getDefaultWithTrim(idNumber);
    }

    private void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }

    private void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }

    private void setFirstSurname(final String firstSurname) {
        this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
    }

    private void setSecondSurname(final String secondSurname) {
        this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
    }

    private void setHomeCity(final CityEntity homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, new CityEntity());
    }

    private void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    private void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = TextHelper.getDefaultWithTrim(mobileNumber);
    }

    private void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    private void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }

    private void setEmailConfirmedIsDefaultValue(final boolean value) {
        this.emailConfirmedIsDefaultValue = value;
    }

    private void setMobileNumberConfirmedIsDefaultValue(final boolean value) {
        this.mobileNumberConfirmedIsDefaultValue = value;
    }
}
