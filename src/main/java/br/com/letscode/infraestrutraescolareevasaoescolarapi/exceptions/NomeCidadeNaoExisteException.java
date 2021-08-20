package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class NomeCidadeNaoExisteException extends RuntimeException{
    public NomeCidadeNaoExisteException(String nomeCidade){
        super("O nome pesquisado: "+nomeCidade+" não exite no banco de dados.");
    }
}
