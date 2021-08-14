package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.CidadeResponse;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeResponse>> buscarCidades(){
        return ResponseEntity.ok().body(cidadeService.buscarCidades());
    }

    @GetMapping("/{idCidade}")
    public ResponseEntity<CidadeResponse> buscarPorID(@PathVariable Long idCidade){
        return ResponseEntity.ok().body(cidadeService.buscarPorId(idCidade));
    }
}
