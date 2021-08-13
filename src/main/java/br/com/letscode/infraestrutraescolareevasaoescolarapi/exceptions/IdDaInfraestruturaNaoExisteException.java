package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDaInfraestruturaNaoExisteException extends RuntimeException {
    public IdDaInfraestruturaNaoExisteException(Long idInfra) {
        super("O Id da Infraestrutura " + idInfra + " pesquisado, não existe no banco de dados.");
    }
}
