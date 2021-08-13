package br.com.letscode.infraestrutraescolareevasaoescolarapi.response;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class InfraestruturaResponse {
    private Long idInfra;
    private Boolean eletricidade;
    private Boolean internet;
    private Boolean computador;
    private Boolean adaptadoPCD;
    private Boolean agua;
    private Boolean aguaPotavel;

    public InfraestruturaResponse(Infraestrutura infraestrutura){
        this.idInfra = infraestrutura.getIdInfra();
        this.eletricidade = infraestrutura.getEletricidade();
        this.internet = infraestrutura.getInternet();
        this.computador = infraestrutura.getComputador();
        this.adaptadoPCD = infraestrutura.getAdaptadoPCD();
        this.agua = infraestrutura.getAgua();
        this.aguaPotavel = infraestrutura.getAguaPotavel();
    }

    public static List<InfraestruturaResponse> convert(List<Infraestrutura> infraestruturas) {
        return infraestruturas.stream().map(InfraestruturaResponse::new).collect(Collectors.toList());
    }
}
