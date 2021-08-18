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
}
