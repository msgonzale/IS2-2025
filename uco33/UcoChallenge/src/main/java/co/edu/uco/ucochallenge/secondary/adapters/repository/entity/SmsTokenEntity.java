
package co.edu.uco.ucochallenge.secondary.adapters.repository.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "sms_token", indexes = @Index(name = "idx_sms_token_user", columnList = "user_id"))
public class SmsTokenEntity {
    @Id
    private String token;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @Column(name="expires_at", nullable = false)
    private Instant expiresAt;

    @Column(name="used", nullable = false)
    private boolean used;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

   
}
