package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.InfraestruturaRepository;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InfraestruturaRequest {
    private Boolean eletricidade;
    private Boolean internet;
    private Boolean computador;
    private Boolean adaptadoPCD;
    private Boolean agua;
    private Boolean aguaPotavel;

    public Infraestrutura convert(){
        return new Infraestrutura(eletricidade, internet, computador, adaptadoPCD, agua, aguaPotavel);
    }
}
