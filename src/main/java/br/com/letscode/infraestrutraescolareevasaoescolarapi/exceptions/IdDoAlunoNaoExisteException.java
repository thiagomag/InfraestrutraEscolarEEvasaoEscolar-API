package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoAlunoNaoExisteException extends RuntimeException {
    public IdDoAlunoNaoExisteException(Long idAluno) {
        super("O Id do Aluno " + idAluno + " pesquisado, não existe no banco de dados.");
    }
}