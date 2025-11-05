package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import java.util.UUID;

import co.edu.uco.ucochallenge.crosscuting.helper.ObjectHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.TextHelper;
import co.edu.uco.ucochallenge.crosscuting.helper.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departamento")
public class StateEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "pais")
	private CountryEntity country;

	@Column(name = "nombre")
	private String name;

	protected StateEntity() {
		setId(UUIDHelper.getDefault());
		setCountry(new CountryEntity());
		setName(TextHelper.getDefault());
	}

	private StateEntity(final Builder builder) {
		setId(builder.id);
		setCountry(builder.country);
		setName(builder.name);
	}

	public static final class Builder {
		private UUID id;
		private CountryEntity country;
		private String name;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder country(final CountryEntity country) {
			this.country = country;
			return this;
		}

		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		public StateEntity build() {
			return new StateEntity(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}

	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}

	private void setCountry(final CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, new CountryEntity());
	}

	private void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

}