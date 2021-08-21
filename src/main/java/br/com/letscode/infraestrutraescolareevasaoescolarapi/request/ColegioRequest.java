package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaInfraestruturaNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.InfraestruturaRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColegioRequest {

    private String nomeColegio;
    private Long idCidade;
    private Integer qtdAtualAlunos;
    private Long idInfraestrutura;

    public Colegio convert(CidadeRepository cidadeRepository, InfraestruturaRepository infraestruturaRepository) {
        var cidade = cidadeRepository.findById(idCidade).orElseThrow(
                () -> new IdDaCidadeNaoExisteException(idCidade));
        var infraestrutura = infraestruturaRepository.findById(idInfraestrutura).orElseThrow(
                () -> new IdDaInfraestruturaNaoExisteException(idInfraestrutura));
        return new Colegio(nomeColegio,cidade,qtdAtualAlunos, infraestrutura);
    }
}
