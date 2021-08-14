package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import lombok.AllArgsConstructor;
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
    public List<Cidade> buscarCidades(){ return cidadeRepository.findAll(); }

    @GetMapping("/buscarPor/{idCidade}")
    public Cidade buscarPorID(@PathVariable Long idCidade){
        return cidadeRepository.getById(idCidade);
    }
}
