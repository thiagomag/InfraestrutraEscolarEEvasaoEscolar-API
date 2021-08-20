package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class ExpiredJwtTokenException extends RuntimeException {
    public ExpiredJwtTokenException() {
        super("Este token JWT espirou.");
    }
}
