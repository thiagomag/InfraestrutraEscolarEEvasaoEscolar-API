package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.CidadeResponse;
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

    private CidadeRepository cidadeRepository;

    @GetMapping
    public List<CidadeResponse> buscarCidades(){
        List cidades = cidadeRepository.findAll();
        return CidadeResponse.convert(cidades);
    }

    @GetMapping("/buscarPor/{idCidade}")
    public ResponseEntity<Cidade> buscarPorID(@PathVariable Long idCidade){
        return ResponseEntity.ok().body(cidadeRepository.getById(idCidade));
    }
}
