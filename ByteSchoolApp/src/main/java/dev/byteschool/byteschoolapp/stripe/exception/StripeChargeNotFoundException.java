package dev.byteschool.byteschoolapp.stripe.exception;

public class StripeProcessingException extends RuntimeException {
    public StripeProcessingException(String message) {
        super(message);
    }

    public StripeProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}