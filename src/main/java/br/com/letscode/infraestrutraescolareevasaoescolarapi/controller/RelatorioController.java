package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @GetMapping("/evasaoEscolar")
    public ResponseEntity<String> relatorioEvasaoEscolar() {
        return relatorioService.relatorioEvasaoEscolar();
    }

    @GetMapping("/evasaoEscolarPorEstado/{estado}")
    public ResponseEntity<String> retorioEvasaoEscolarPorEstado(@PathVariable String estado) {
        return relatorioService.retorioEvasaoEscolarPorEstado(estado);
    }

    @GetMapping("/evasaoEscolarPorSexo/{sexo}")
    public ResponseEntity<String> relatorioEvasaoEscolarPorSexo(@PathVariable String sexo) {
        return relatorioService.relatorioEvasaoEscolarPorSexo(sexo);
    }

    @GetMapping("/evasaoEscolarPorIdade/{anoNascimento}")
    public ResponseEntity<String> relatorioEvasaoEscolarPorIdade(@PathVariable Integer anoNascimento) {
        return relatorioService.relatorioEvasaoEscolarPorIdade(anoNascimento);
    }

    @GetMapping("/infraestrutura")
    public ResponseEntity<String> relatorioInfraestrutura() {
        return relatorioService.relatorioInfraestrutura();
    }

    @GetMapping("/infraestruturaPorEstado/{nome}")
    public ResponseEntity<String> relatorioInfraestruturaPorEstado(@PathVariable String nome) {
        return relatorioService.relatorioInfraestruturaPorEstado(nome);
    }
}
