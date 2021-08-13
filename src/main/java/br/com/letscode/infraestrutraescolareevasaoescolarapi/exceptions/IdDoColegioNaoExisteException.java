package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoColegioNaoExisteException extends RuntimeException {
    public IdDoColegioNaoExisteException(Long idColegio) {
        super("O Id do Colegio " + idColegio + " pesquisado, não existe no banco de dados.");
    }
}