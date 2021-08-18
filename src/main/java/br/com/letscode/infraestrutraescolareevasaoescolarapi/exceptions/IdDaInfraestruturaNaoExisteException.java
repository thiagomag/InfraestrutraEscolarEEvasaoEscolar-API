package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class IdDaInfraestruturaNaoExisteException extends RuntimeException {
    public IdDaInfraestruturaNaoExisteException(Long idInfra) {
        super("O Id " + idInfra + ", da Infraestrutura pesquisada, não existe no banco de dados.");
    }
}
