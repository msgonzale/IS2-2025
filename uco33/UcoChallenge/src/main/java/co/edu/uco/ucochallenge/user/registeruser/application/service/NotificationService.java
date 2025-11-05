package co.edu.uco.ucochallenge.user.registeruser.application.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmailVerification(String email, String token) {
        System.out.println("[EMAIL] Enviando verificación a " + email + " con token: " + token);
    }

    public void sendSmsVerification(String phone, String token) {
        System.out.println("[SMS] Enviando verificación a " + phone + " con token: " + token);
    }

    public void notifyActor(String actor, String message) {
        System.out.println("[NOTIFY actor=" + actor + "] " + message);
    }

    public void notifyOwnerEmail(String email, String message) {
        System.out.println("[NOTIFY OWNER EMAIL] " + email + ": " + message);
    }

    public void notifyOwnerSms(String phone, String message) {
        System.out.println("[NOTIFY OWNER SMS] " + phone + ": " + message);
    }

    public void notifyAdmin(String message) {
        System.out.println("[ADMIN ALERT] " + message);
    }
}
