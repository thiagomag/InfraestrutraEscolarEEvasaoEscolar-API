package br.com.letscode.infraestrutraescolareevasaoescolarapi.response;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Aluno;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class AlunoResponse {

    private Long idAluno;
    private String nomeAluno;
    private Colegio colegio;
    private LocalDate dataNascimento;
    private String serieEscolarAtual;
    private Boolean concluiuEstudos;
    private Boolean ehEstudante;

    public AlunoResponse(Aluno aluno) {
        this.idAluno = aluno.getIdAluno();
        this.nomeAluno = aluno.getNomeAluno();
        this.colegio = aluno.getColegio();
        this.dataNascimento = aluno.getDataNascimento();
        this.serieEscolarAtual = aluno.getSerieEscolarAtual();
        this.ehEstudante = aluno.getEhEstudante();
    }

    public static List<AlunoResponse> convert(List<Aluno> alunos) {
        return alunos.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }
}
