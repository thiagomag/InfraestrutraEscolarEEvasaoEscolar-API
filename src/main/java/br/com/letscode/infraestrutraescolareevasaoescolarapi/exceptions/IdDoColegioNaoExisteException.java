package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class IdDoColegioNaoExisteException extends RuntimeException {
    public IdDoColegioNaoExisteException(Long idColegio) {
        super("O Id " + idColegio + ", do Colegio pesquisado, não existe no banco de dados.");
    }
}