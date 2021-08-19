package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnableToGetJwtTokenException extends RuntimeException {
    public UnableToGetJwtTokenException() {
        super("Não foi possível capturar o token JWT.");
    }
}
