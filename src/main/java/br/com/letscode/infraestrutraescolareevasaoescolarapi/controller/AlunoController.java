package br.com.letscode.infraestrutraescolareevasaoescolarapi.controller;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.AlunoRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.AlunoReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.AlunoResponse;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/buscarAluno")
    private List<AlunoResponse> buscarAlunos() {
        return alunoService.buscarAluno();
    }

    @GetMapping("/buscarAluno/buscaPorNome/{nomeAluno}")
    private List<AlunoResponse> buscarPorNome(@PathVariable String nomeAluno) {
        return alunoService.buscarPorNome(nomeAluno);
    }

    @GetMapping("/buscarAluno/nomeCurso/{nomeColegio}")
    private List<AlunoResponse> buscarPorNomeColegio(@PathVariable String nomeColegio) {
        return alunoService.buscarPorNomeColegio(nomeColegio);
    }

    @GetMapping("/buscarAluno/buscaPorID/{idAluno}")
    private AlunoResponse buscarPorId(@PathVariable Long idAluno) {
        return alunoService.buscarPorId(idAluno);
    }

    @GetMapping("/buscarAluno/buscarPorNascimento/{anoNascimento}")
    private List<AlunoResponse> buscarPorAnoNascimento(@PathVariable Integer anoNascimeto) {
        return alunoService.buscarPorAnoNascimento(anoNascimeto);
    }

    @PostMapping("/adcionarAluno")
    private ResponseEntity<AlunoResponse> adicionarAluno(@RequestBody AlunoRequest alunoRequest,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        return alunoService.adicionarAluno(alunoRequest, uriComponentsBuilder);
    }

    @DeleteMapping("deletarAluno/{idColegio}")
    private ResponseEntity<?> deletarAluno(@PathVariable Long idColegio) {
        return alunoService.deletarAluno(idColegio);
    }

    @PatchMapping("atualizarAluno/{idAluno}")
    private ResponseEntity<AlunoResponse> atualizarAluno(@RequestBody AlunoReqAtualizar alunoReqAtualizar, @PathVariable Long idAluno) {
        return alunoService.atualizarAluno(alunoReqAtualizar, idAluno);
    }
}
