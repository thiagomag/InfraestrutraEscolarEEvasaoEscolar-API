package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDoAlunoNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.AlunoRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.ColegioRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.AlunoRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.AlunoReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.AlunoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final ColegioRepository colegioRepository;

    public List<AlunoResponse> buscarAluno() {
        var alunos = alunoRepository.findAll();
        return AlunoResponse.convert(alunos);
    }

    public List<AlunoResponse> buscarPorNome(String nomeAluno) {
        var alunos = alunoRepository.findByNomeAluno(nomeAluno);
        return AlunoResponse.convert(alunos);
    }

    public List<AlunoResponse> buscarPorNomeColegio(String nomeColegio) {
        var alunos = alunoRepository.findByColegio_NomeColegio(nomeColegio);
        return AlunoResponse.convert(alunos);
    }
    
    public ResponseEntity<?> buscarPorId(Long idAluno) {
        var aluno = alunoRepository.findById(idAluno);
        if(aluno.isPresent()) {
            return ResponseEntity.ok().body(new AlunoResponse(aluno.get()));
        } else {
            return ResponseEntity.ok().body(new IdDoAlunoNaoExisteException(idAluno));
        }
    }

    public ResponseEntity<List<AlunoResponse>> buscarPorAnoNascimento(Integer anoNascimeto) {
        var aluno = alunoRepository.findByAnoNascimento(anoNascimeto);
        return ResponseEntity.ok().body(AlunoResponse.convert(aluno));
    }

    public ResponseEntity<AlunoResponse> adicionarAluno(AlunoRequest alunoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var aluno = alunoRequest.convert(colegioRepository);
        alunoRepository.save(aluno);
        var uri = uriComponentsBuilder.path("/alunos/buscarAlunos/{id}").buildAndExpand(aluno.getIdAluno()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    public ResponseEntity<?> deletarAluno(Long idColegio) {
        if(alunoRepository.findById(idColegio).isPresent()) {
            alunoRepository.deleteById(idColegio);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoAlunoNaoExisteException(idColegio);
        }
    }

    public ResponseEntity<AlunoResponse> atualizarAluno(AlunoReqAtualizar alunoReqAtualizar, Long idAluno) {
        var alunoOptional = alunoRepository.findById(idAluno).orElseThrow(() -> new IdDoAlunoNaoExisteException(idAluno));
        if(alunoReqAtualizar.getNomeAluno() == null) {
            alunoReqAtualizar.setNomeAluno(alunoOptional.getNomeAluno());
        }
        if(alunoReqAtualizar.getDataNascimento() == null) {
            alunoReqAtualizar.setDataNascimento(alunoOptional.getDataNascimento());
        }
        if(alunoReqAtualizar.getCodigoColegio() == null) {
            alunoReqAtualizar.setCodigoColegio(alunoOptional.getColegio().getIdColegio());
        }
        if(alunoReqAtualizar.getDataNascimento() == null) {
            alunoReqAtualizar.setDataNascimento(alunoOptional.getDataNascimento());
        }
        if(alunoReqAtualizar.getConcluiuEstudos() == null) {
            alunoReqAtualizar.setConcluiuEstudos(alunoOptional.getConcluiuEstudos());
        }
        if(alunoReqAtualizar.getEhEstudante() == null) {
            alunoReqAtualizar.setEhEstudante(alunoOptional.getEhEstudante());
        }
        var aluno = alunoReqAtualizar.convert(colegioRepository, idAluno);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }
}