package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.InfraestruturaRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.InfraestruturaReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.InfraestruturaResponse;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.InfraestruturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/infraestrutura")
@RequiredArgsConstructor
public class InfraestruturaController {

    private final InfraestruturaService infraestruturaService;

    @GetMapping("/buscaInfraestrutura")
    private List<InfraestruturaResponse> buscarInfraestrutura() {
        return infraestruturaService.buscarInfraestrutura();
    }

    @GetMapping("/buscaInfraestrutura/buscarPorEletricidade/{eletricidade}")
    private List<InfraestruturaResponse> buscarPorEletricidade(@PathVariable Boolean eletricidade){
        return infraestruturaService.buscarPorEletricidade(eletricidade);
    }

    @GetMapping("/buscaInfraestrutura/buscarPorInternet/{internet}")
    private List<InfraestruturaResponse> buscarPorInternet(@PathVariable Boolean internet){
        return infraestruturaService.buscarPorInternet(internet);
    }

    @GetMapping("/buscaInfraestrutura/buscarPorComputador/{computador}")
    private List<InfraestruturaResponse> buscarPorComputador(@PathVariable Boolean computador){
        return infraestruturaService.buscarPorComputador(computador);
    }

    @GetMapping("/buscaInfraestrutura/buscarPorAdaptadorPCD/{adaptadoPCD}")
    private List<InfraestruturaResponse> buscarPorAdaptadorPCD(@PathVariable Boolean adaptadoPCD){
        return infraestruturaService.buscarPorAdaptadorPCD(adaptadoPCD);
    }

    @GetMapping("/buscaInfraestrutura/busucarPorAgua/{agua}")
    private List<InfraestruturaResponse> busucarPorAgua(@PathVariable Boolean agua){
        return infraestruturaService.buscarPorAgua(agua);
    }

    @GetMapping("/buscaInfraestrutura/buscarPorAguaPotavel/{aguaPotavel}")
    private List<InfraestruturaResponse> buscarPorAguaPotavel(@PathVariable Boolean aguaPotavel){
        return infraestruturaService.buscarPorAguaPotavel(aguaPotavel);
    }

    @PostMapping("/adicionarInfraestrutura")
    private Infraestrutura adicionarInfraestrutura(@RequestBody InfraestruturaRequest infraestruturaRequest) {
        return infraestruturaService.adicionarInfraestrutura(infraestruturaRequest);
    }

    @PatchMapping("atualizarInfraestrutura/{idInfra}")
    private ResponseEntity<InfraestruturaResponse> infraestruturaAluno(
            @RequestBody InfraestruturaReqAtualizar infraestruturaReqAtualizar,
            @PathVariable Long idInfra) {
        return infraestruturaService.atualizarInfraestrutura(infraestruturaReqAtualizar, idInfra);
    }
}
