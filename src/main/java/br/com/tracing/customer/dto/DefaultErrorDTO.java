package br.com.tracing.customer.dto;

import java.io.Serializable;

public class DefaultErrorDTO implements Serializable {

    private String message;

    public DefaultErrorDTO() {
    }

    public DefaultErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
