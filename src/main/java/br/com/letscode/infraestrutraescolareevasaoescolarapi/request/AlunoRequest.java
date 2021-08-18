package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Aluno;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDoColegioNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.ColegioRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {

    private String nomeAluno;
    private String sexo;
    private Long codigoColegio;
    private LocalDate dataNascimento;
    private String serieEscolarAtual;
    private Boolean concluiuEstudos;
    private Boolean ehEstudante;

    public Aluno convert(ColegioRepository colegioRepository) {
        var colegio = colegioRepository.findById(codigoColegio).orElseThrow(() -> new IdDoColegioNaoExisteException(codigoColegio));
        return new Aluno(nomeAluno, sexo, colegio, dataNascimento, serieEscolarAtual, concluiuEstudos, ehEstudante);
    }
}