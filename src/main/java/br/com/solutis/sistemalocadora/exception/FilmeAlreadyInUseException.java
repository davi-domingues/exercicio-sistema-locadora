package br.com.solutis.sistemalocadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FilmeAlreadyInUseException extends RuntimeException {
    public FilmeAlreadyInUseException(String message) {
        super(message);
    }
}
