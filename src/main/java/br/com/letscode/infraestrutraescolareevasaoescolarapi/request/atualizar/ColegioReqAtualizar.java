package br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.InfraestruturaRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ColegioReqAtualizar {

    private String nomeColegio;
    private Long idCidade;
    private Integer qtdAtualAlunos;
    private InfraestruturaRequest infraestrutura;

    public Colegio convert(CidadeRepository cidadeRepository, Long idColegio) {
        var cidade = cidadeRepository.findById(idCidade).orElseThrow(
                () -> new IdDaCidadeNaoExisteException(idCidade));
        var infraestrutura = this.infraestrutura.convert();
        return Colegio.builder()
                .idColegio(idColegio)
                .nomeColegio(nomeColegio)
                .cidade(cidade)
                .qtdAtualAlunos(qtdAtualAlunos)
                .infraestrutura(infraestrutura)
                .build();
    }
}