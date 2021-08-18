package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.CidadeRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.CidadeReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.CidadeResponse;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping
    public List<CidadeResponse> buscarCidades(){
        return cidadeService.buscarCidades();
    }

    @GetMapping("/{idCidade}")
    public ResponseEntity<?> buscarPorID(@PathVariable Long idCidade){
        return cidadeService.buscarPorId(idCidade);
    }

    @GetMapping("/buscar_nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
        return cidadeService.buscarPorNomeCidade(nome);
    }

    @PostMapping
    public ResponseEntity<CidadeResponse> adicionar(@RequestBody CidadeRequest cidadeRequest,
                                                    UriComponentsBuilder uriComponentsBuilder){
        return cidadeService.incluirCidade(cidadeRequest, uriComponentsBuilder);
    }

    @PutMapping("/{idCidade}")
    public ResponseEntity<?> atualizarCidadePorId(@RequestBody CidadeReqAtualizar cidadeReqAtualizar, @PathVariable Long idCidade){
        return cidadeService.atualizarCidadePorId(cidadeReqAtualizar, idCidade);
    }

}
