package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

public class IdDoAlunoNaoExisteException extends RuntimeException {
    public IdDoAlunoNaoExisteException(Long idAluno) {
        super("O Id " + idAluno + ", do Aluno pesquisado, não existe no banco de dados.");
    }
}