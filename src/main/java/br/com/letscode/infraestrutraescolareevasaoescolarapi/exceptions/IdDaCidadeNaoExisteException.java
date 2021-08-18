package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class IdDaCidadeNaoExisteException extends RuntimeException {
    public IdDaCidadeNaoExisteException(Long idCidade) {
        super("O Id " + idCidade + ", da Cidade pesquisada, não existe no banco de dados.");
    }
}
