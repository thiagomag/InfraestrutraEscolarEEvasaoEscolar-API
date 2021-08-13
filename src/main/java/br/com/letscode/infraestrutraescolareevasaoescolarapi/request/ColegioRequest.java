package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaInfraestruturaNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
        return new Colegio(nomeColegio,cidade,qtdAtualAlunos,infraestrutura);
    }
}
