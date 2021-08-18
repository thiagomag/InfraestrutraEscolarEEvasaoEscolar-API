package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
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
    private InfraestruturaRequest infraestrutura;

    public Colegio convert(CidadeRepository cidadeRepository) {
        var cidade = cidadeRepository.findById(idCidade).orElseThrow(
                () -> new IdDaCidadeNaoExisteException(idCidade));
        var infraestrutura = this.infraestrutura.convert();
        return new Colegio(nomeColegio,cidade,qtdAtualAlunos, infraestrutura);
    }
}
