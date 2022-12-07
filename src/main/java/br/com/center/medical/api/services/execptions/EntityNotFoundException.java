package br.com.center.medical.api.services.execptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;

    public EntityNotFoundException(HttpStatus httpStatus, String msg) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
