package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Aluno;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.AlunoRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.ColegioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final ColegioRepository colegioRepository;
    private final AlunoRepository alunoRepository;

    public ResponseEntity<String> relatorioEvasaoEscolar() {
        List<Aluno> alunoList = alunoRepository.findAll();
        List<Aluno> alunosConcluidos = alunoList.stream().filter(Aluno::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusao = ((double) alunosConcluidos.size() / alunoList.size()) * 100;
        var percEvasao = 100 - percConclusao;
        return ResponseEntity.ok().body("O percentual de conclusão dos estudos no país é de " + percConclusao + "%\n" +
                "O percentual de evasão dos estudos no país é de " + percEvasao + "%");
    }

    public ResponseEntity<String> retorioEvasaoEscolarPorEstado(String estado) {
        List<Aluno> alunoList = alunoRepository.findAll();
        List<Aluno> alunosConcluidosPorEstado = alunoList.stream().filter(aluno ->
                aluno.getColegio().getCidade().getEstado().equals(estado)).filter(Aluno::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusaoPorEstado = ((double) alunosConcluidosPorEstado.size() / alunoList.size()) * 100;
        var percEvasaoPorEStado = 100 - percConclusaoPorEstado;
        return ResponseEntity.ok().body("O percentual de conclusão dos estudos no estado do(e) " + estado + " é de " + percConclusaoPorEstado + "%\n" +
                "O Percental de evasão escolar no estado do(e) " + estado + " é de " + percEvasaoPorEStado + "%\n");
    }

    public ResponseEntity<String> relatorioEvasaoEscolarPorSexo(String sexo) {
        List<Aluno> alunoList = alunoRepository.findAll();
        List<Aluno> alunosConcluidosPorSexo = alunoList.stream().filter(aluno ->
                aluno.getSexo().equals(sexo)).filter(Aluno::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusaoPorSexo = ((double) alunosConcluidosPorSexo.size() / alunoList.size()) * 100;
        var percEvasaoPorSexo = 100 - percConclusaoPorSexo;
        return ResponseEntity.ok().body("O percentual de conclusão dos estudantes do sexo " + sexo + " é de " + percConclusaoPorSexo + "%\n" +
                "O percentual de evasão dos estudantes do sexo " + sexo + " é de " + percEvasaoPorSexo);
    }

    public ResponseEntity<String> relatorioEvasaoEscolarPorIdade(Integer anoNascimento) {
        List<Aluno> alunosPorIdade = alunoRepository.findByAnoNascimento(anoNascimento);
        List<Aluno> alunosConluidos = alunosPorIdade.stream().filter(Aluno::getConcluiuEstudos).collect(Collectors.toList());
        var percConclusaoPorIdade = ((double) alunosConluidos.size() / alunosPorIdade.size()) * 100;
        var percEvasaoPorIdade = 100 - percConclusaoPorIdade;
        return ResponseEntity.ok().body("O percentual de conclusão dos estudantes nascidos em " + anoNascimento + " é de " + percConclusaoPorIdade + "%" +
                "O percentual de evasão dos estudantes nascidos em " + anoNascimento + " é de " + percEvasaoPorIdade);
    }

    public ResponseEntity<String> relatorioInfraestrutura() {
        List<Colegio> colegioList = colegioRepository.findAll();
        List<Colegio> colegioListEletricidade = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getEletricidade()).collect(Collectors.toList());
        List<Colegio> colegioListAdaptadoPCD = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAdaptadoPCD()).collect(Collectors.toList());
        List<Colegio> colegioListAgua = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAgua()).collect(Collectors.toList());
        List<Colegio> colegioListAguaPotavel = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAguaPotavel()).collect(Collectors.toList());
        List<Colegio> colegioListComputador = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getComputador()).collect(Collectors.toList());
        List<Colegio> colegioListInternet = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getInternet()).collect(Collectors.toList());
        var percColegioEletricidade = ((double) colegioListEletricidade.size() / colegioList.size()) * 100;
        var percColegioAdaptadoPCD = ((double) colegioListAdaptadoPCD.size() / colegioList.size()) * 100;
        var percColegioAgua = ((double) colegioListAgua.size() / colegioList.size()) * 100;
        var percColegioAguaPotavel = ((double) colegioListAguaPotavel.size() / colegioList.size()) * 100;
        var percColegioComputador = ((double) colegioListComputador.size() / colegioList.size()) * 100;
        var percColegioInternet = ((double) colegioListInternet.size() / colegioList.size()) * 100;
        return ResponseEntity.ok().body("Percentual de colégios com infraestutura\n" +
                "  Eletricidade  | Adaptado a PCD |     Água      |  Agua Potável  |   Computador   |    Internet    \n" +
                "     " + String.format("%5.2f", percColegioEletricidade) + "      " +
                "      " + String.format("%5.2f", percColegioAdaptadoPCD) + "      " +
                "      " + String.format("%5.2f", percColegioAgua) + "      " +
                "      " + String.format("%5.2f", percColegioAguaPotavel) + "      " +
                "      " + String.format("%5.2f", percColegioComputador) + "      " +
                "      " + String.format("%5.2f", percColegioInternet) + "      ");
    }

    public ResponseEntity<String> relatorioInfraestruturaPorEstado(String estado) {
        List<Colegio> colegioList = colegioRepository.findColegioByCidade_Estado(estado);
        List<Colegio> colegioListEletricidade = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getEletricidade()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        List<Colegio> colegioListAdaptadoPCD = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAdaptadoPCD()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        List<Colegio> colegioListAgua = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAgua()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        List<Colegio> colegioListAguaPotavel = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getAguaPotavel()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        List<Colegio> colegioListComputador = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getComputador()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        List<Colegio> colegioListInternet = colegioList.stream().filter(colegio ->
                colegio.getInfraestrutura().getInternet()).filter(colegio -> colegio.getCidade().getEstado()
                .equals(estado.toUpperCase())).collect(Collectors.toList());
        var percColegioEletricidade = ((double) colegioListEletricidade.size() / colegioList.size()) * 100;
        var percColegioAdaptadoPCD = ((double) colegioListAdaptadoPCD.size() / colegioList.size()) * 100;
        var percColegioAgua = ((double) colegioListAgua.size() / colegioList.size()) * 100;
        var percColegioAguaPotavel = ((double) colegioListAguaPotavel.size() / colegioList.size()) * 100;
        var percColegioComputador = ((double) colegioListComputador.size() / colegioList.size()) * 100;
        var percColegioInternet = ((double) colegioListInternet.size() / colegioList.size()) * 100;
        return ResponseEntity.ok().body("Percentual de colégios com infraestutura do estado do " + estado + "\n" +
                "  Eletricidade  | Adaptado a PCD |     Água      |  Agua Potável  |   Computador   |    Internet    \n" +
                "     " + String.format("%5.2f", percColegioEletricidade) + "      " +
                "      " + String.format("%5.2f", percColegioAdaptadoPCD) + "      " +
                "      " + String.format("%5.2f", percColegioAgua) + "      " +
                "      " + String.format("%5.2f", percColegioAguaPotavel) + "      " +
                "      " + String.format("%5.2f", percColegioComputador) + "      " +
                "      " + String.format("%5.2f", percColegioInternet) + "      ");
    }
}