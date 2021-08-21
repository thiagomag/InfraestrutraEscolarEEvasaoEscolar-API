package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.ColegioRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.ColegioReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.ColegioResponse;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.ColegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colegio")
public class ColegioController {

    private final ColegioService colegioService;

    @GetMapping("/listarcolegios")
    public List<ColegioResponse> listarColegios() {
        return colegioService.listarColegios();
    }

    @GetMapping("/buscarporid/{id}")
    public ColegioResponse buscarPorId(@PathVariable Long id) {
        return colegioService.buscarPorId(id);
    }

    @GetMapping("/buscarpornome/{nome}")
    public List<ColegioResponse> buscarPorNome(@PathVariable String nome) {
        return colegioService.buscarPorNome(nome);
    }

    @GetMapping("/buscarporcidade/{nome}")
    public List<ColegioResponse> buscarPorCidade(@PathVariable String nome) {
        return colegioService.buscarPorNomeCidade(nome);
    }

    @GetMapping("/buscarporestado/{nome}")
    public List<ColegioResponse> buscarPorEstado(@PathVariable String nome) {
        return colegioService.buscarPorEstado(nome);
    }

    @PostMapping("/adicionarColegio")
    private ResponseEntity<ColegioResponse> adicionarColegio(@RequestBody ColegioRequest colegioRequest,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        return colegioService.adicionarColegio(colegioRequest, uriComponentsBuilder);
    }

    @DeleteMapping("/apagarcolegio/{id}")
    public ResponseEntity<?> apagarColegio(@PathVariable Long id) {
        return colegioService.apagarColegio(id);
    }

    @PutMapping("/atualizacolegio/{id}")
    public ResponseEntity<ColegioResponse> atualizarColegio(@RequestBody ColegioReqAtualizar colegioReqAtualizar,
                                                           @PathVariable Long id) {
        return colegioService.atualizarColegio(colegioReqAtualizar,id);
    }
}
