package dev.byteschool.byteschoolapp;

import com.stripe.exception.StripeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StripeException.class)
    public ResponseEntity<String> handleStripeException(Exception ex) {
        log.error("Stripe Exception: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalStateException(Exception ex) {
        log.error("Illegal State: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), BAD_REQUEST);
    }
}
