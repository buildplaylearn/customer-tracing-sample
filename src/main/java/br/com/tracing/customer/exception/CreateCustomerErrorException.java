package br.com.tracing.customer.exception;

public class CreateCustomerErrorException extends RuntimeException {

    public CreateCustomerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
