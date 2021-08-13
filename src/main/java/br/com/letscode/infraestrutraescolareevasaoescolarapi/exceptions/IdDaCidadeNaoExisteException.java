package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDaCidadeNaoExisteException extends RuntimeException {
    public IdDaCidadeNaoExisteException(Long idCidade) {
        super("O Id da Cidade " + idCidade + " pesquisado, não existe no banco de dados.");
    }
}
