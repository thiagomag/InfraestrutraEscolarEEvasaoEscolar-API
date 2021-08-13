package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.InfraestruturaRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.InfraestruturaRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.InfraestruturaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfraestruturaService {

    private final InfraestruturaRepository infraestruturaRepository;

    public List<InfraestruturaResponse> buscarInfraestrutura(){
        var infraestruturas = infraestruturaRepository.findAll();
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorEletricidade(Boolean eletricidade){
        var infraestruturas = infraestruturaRepository.findByEletricidade(eletricidade);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorInternet(Boolean internet){
        var infraestruturas = infraestruturaRepository.findByInternet(internet);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorComputador(Boolean computador){
        var infraestruturas = infraestruturaRepository.findByComputador(computador);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorAdaptadorPCD(Boolean adaptadorPCD){
        var infraestruturas = infraestruturaRepository.findByadaptadoPCD(adaptadorPCD);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorAgua(Boolean agua){
        var infraestruturas = infraestruturaRepository.findByAgua(agua);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public List<InfraestruturaResponse> buscarPorAguaPotavel(Boolean aguaPotavel){
        var infraestruturas = infraestruturaRepository.findByAguaPotavel(aguaPotavel);
        return InfraestruturaResponse.convert(infraestruturas);
    }

    public Infraestrutura adicionarInfraestrutura(InfraestruturaRequest infraestruturaRequest) {
        var infraestrutura = infraestruturaRequest.convert();
        return infraestruturaRepository.save(infraestrutura);
    }
}
