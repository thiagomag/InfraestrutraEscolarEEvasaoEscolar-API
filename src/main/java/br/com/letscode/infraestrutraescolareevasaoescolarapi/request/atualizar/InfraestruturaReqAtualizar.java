package br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaInfraNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.InfraestruturaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InfraestruturaReqAtualizar {
    private Boolean eletricidade;
    private Boolean internet;
    private Boolean computador;
    private Boolean adaptadoPCD;
    private Boolean agua;
    private Boolean aguaPotavel;

    public Infraestrutura convert(InfraestruturaRepository infraestruturaRepository, Long idInfra) {
        infraestruturaRepository.findById(idInfra).orElseThrow(() -> new IdDaInfraNaoExisteException(idInfra));
        return Infraestrutura.builder()
                .idInfra(idInfra)
                .eletricidade(eletricidade)
                .internet(internet)
                .computador(computador)
                .adaptadoPCD(adaptadoPCD)
                .agua(agua)
                .aguaPotavel(aguaPotavel)
                .build();
    }
}
