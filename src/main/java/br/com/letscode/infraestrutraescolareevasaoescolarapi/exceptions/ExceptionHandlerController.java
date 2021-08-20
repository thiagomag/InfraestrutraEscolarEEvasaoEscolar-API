package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(IdDoAlunoNaoExisteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdDoAlunoNaoExisteException(IdDoAlunoNaoExisteException ex){
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdDaCidadeNaoExisteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdDaCidadeNaoExisteException(IdDaCidadeNaoExisteException ex){
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdDoColegioNaoExisteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdDoColegioNaoExisteException(IdDoColegioNaoExisteException ex){
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdDaInfraestruturaNaoExisteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdDaInfraestruturaNaoExisteException(IdDaInfraestruturaNaoExisteException ex){
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NomeCidadeNaoExisteException.class)
    public final ResponseEntity<ExceptionResponse> handleNomeCidadeNaoExisteException(NomeCidadeNaoExisteException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnableToGetJwtTokenException.class)
    public final ResponseEntity<ExceptionResponse> handleUnableToGetJwtTokenException(UnableToGetJwtTokenException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ExpiredJwtTokenException.class)
    public final ResponseEntity<ExceptionResponse> handleExpiredJwtTokenException(ExpiredJwtTokenException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
