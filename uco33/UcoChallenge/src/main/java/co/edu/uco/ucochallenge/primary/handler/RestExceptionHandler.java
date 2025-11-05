package co.edu.uco.ucochallenge.primary.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleConstraint(DataIntegrityViolationException ex) {
        String msg = ex.getMostSpecificCause().getMessage();
        String reason = "Registro duplicado";

        if (msg != null) {
            if (msg.contains("uk_usuario_email")) {
                reason = "Ya existe un usuario con este email.";
            } else if (msg.contains("uk_usuario_mobile")) {
                reason = "Ya existe un usuario con este número móvil.";
            } else if (msg.contains("uk_usuario_tipo_numero")) {
                reason = "Ya existe un usuario con este tipo y número de identificación.";
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", reason));
    }
}

