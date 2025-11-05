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
@Table(name = "Ciudad")
public class CityEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "departamento")
	private StateEntity state;

	@Column(name = "nombre")
	private String name;

	protected CityEntity() {
		setId(UUIDHelper.getDefault());
		setState(new StateEntity());
		setName(TextHelper.getDefault());
	}

	private CityEntity(final Builder builder) {
		setId(builder.id);
		setState(builder.state);
		setName(builder.name);
	}

	public static class Builder {
		private UUID id;
		private StateEntity state;
		private String name;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder state(final StateEntity state) {
			this.state = state;
			return this;
		}

		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		public CityEntity build() {
			return new CityEntity(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public StateEntity getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}

	private void setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, new StateEntity());
	}

	private void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
}
