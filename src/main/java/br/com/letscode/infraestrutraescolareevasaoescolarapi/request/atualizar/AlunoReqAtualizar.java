package br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Aluno;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDoColegioNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.ColegioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AlunoReqAtualizar {

    private String nomeAluno;
    private Long codigoColegio;
    private LocalDate dataNascimento;
    private String sexo;
    private String serieEscolarAtual;
    private Boolean concluiuEstudos;
    private Boolean ehEstudante;

    public Aluno convert(ColegioRepository colegioRepository, Long idAluno) {
        var colegio = colegioRepository.findById(codigoColegio).orElseThrow(() -> new IdDoColegioNaoExisteException(codigoColegio));
        return Aluno.builder()
                .idAluno(idAluno)
                .nomeAluno(nomeAluno)
                .colegio(colegio)
                .dataNascimento(dataNascimento)
                .sexo(sexo)
                .serieEscolarAtual(serieEscolarAtual)
                .concluiuEstudos(concluiuEstudos)
                .ehEstudante(ehEstudante)
                .build();
    }
}
