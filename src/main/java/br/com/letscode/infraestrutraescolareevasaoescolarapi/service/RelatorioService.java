package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.AlunoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final ColegioService colegioService;
    private final AlunoService alunoService;

    public ResponseEntity<String> relatorioEvasaoEscolar() {
        List<AlunoResponse> alunoList = alunoService.buscarAluno();
        List<AlunoResponse> alunosConcluidos = alunoList.stream().filter(AlunoResponse::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusao = ((double) alunosConcluidos.size() / alunoList.size());
        return ResponseEntity.ok().body("O percentual de conclusão dos estudos no país é de " + percConclusao + "%");
    }


    public ResponseEntity<String> retorioEvasaoEscolarPorEstado(String estado) {
        List<AlunoResponse> alunoList = alunoService.buscarAluno();
        List<AlunoResponse> alunosConcluidosPorEstado = alunoList.stream().filter(aluno ->
                aluno.getColegio().getCidade().getEstado().equals(estado)).filter(AlunoResponse::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusaoPorEstado = ((double) alunoList.size() / alunosConcluidosPorEstado.size());
        return ResponseEntity.ok().body("O percentual de conclusão dos estudos no estado do(e) " + estado + " é de " + percConclusaoPorEstado + "%");
    }

    public ResponseEntity<String> relatorioEvasaoEscolarPorSexo(String sexo) {
        List<AlunoResponse> alunoList = alunoService.buscarAluno();
        List<AlunoResponse> alunosConcluidosPorEstado = alunoList.stream().filter(aluno ->
                aluno.getSexo().equals(sexo)).filter(AlunoResponse::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusaoPorEstado = ((double) alunoList.size() / alunosConcluidosPorEstado.size());
        return ResponseEntity.ok().body("O percentual de conclusão dos estudos do sexo " + sexo + " é de " + percConclusaoPorEstado + "%");
    }
}