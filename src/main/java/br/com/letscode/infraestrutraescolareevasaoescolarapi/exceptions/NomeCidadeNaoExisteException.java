package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NomeCidadeNaoExisteException extends RuntimeException{
    public NomeCidadeNaoExisteException(String nomeCidade){
        super("O nome pesquisado: "+nomeCidade+" não exite no banco de dados.");
    }
}
