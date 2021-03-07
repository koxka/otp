package hu.otp.ticketing.api.common.exception;

public class MissingHeaderException extends RuntimeException {

    public MissingHeaderException(String message) {
        super(message);
    }
}
