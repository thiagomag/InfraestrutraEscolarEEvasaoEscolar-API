package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class UnableToGetJwtTokenException extends RuntimeException {
    public UnableToGetJwtTokenException() {
        super("Não foi possível capturar o token JWT.");
    }
}
