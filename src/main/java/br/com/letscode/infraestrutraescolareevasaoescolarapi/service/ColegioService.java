package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDoColegioNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.ColegioRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.InfraestruturaRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.ColegioRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.InfraestruturaRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.ColegioReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.ColegioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColegioService {

    private final ColegioRepository colegioRepository;
    private final CidadeRepository cidadeRepository;
    private final InfraestruturaRepository infraestruturaRepository;

    public List<ColegioResponse> listarColegios() {
        var colegios = colegioRepository.findAll();
        return ColegioResponse.convert(colegios);
    }

    public ColegioResponse buscarPorId(Long id) {
        var colegio = colegioRepository.findById(id).orElseThrow(
                () -> new IdDoColegioNaoExisteException(id));
        return new ColegioResponse(colegio);
    }

    public List<ColegioResponse> buscarPorNome(String nome) {
        var colegios = colegioRepository.findByNomeColegio(nome);
        return ColegioResponse.convert(colegios);
    }

    public List<ColegioResponse> buscarPorNomeCidade(String nome) {
        var colegios = colegioRepository.findColegioByCidade(nome);
        return ColegioResponse.convert(colegios);
    }

    public ResponseEntity<ColegioResponse> adicionarColegio(ColegioRequest colegioRequest,
                                                            UriComponentsBuilder builder) {
        var colegio = colegioRequest.convert(cidadeRepository);
        colegioRepository.save(colegio);
        var uri = builder.path("/colegio/adicionarcolegio/{id}")
                .buildAndExpand(colegio.getIdColegio()).toUri();
        return ResponseEntity.created(uri).body(new ColegioResponse(colegio));
    }

    public ResponseEntity<?> apagarColegio(Long idColegio) {
        if(colegioRepository.findById(idColegio).isPresent()) {
            colegioRepository.deleteById(idColegio);
            var colegio = colegioRepository.findById(idColegio);
            infraestruturaRepository.deleteById(colegio.get().getInfraestrutura().getIdInfra());
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoColegioNaoExisteException(idColegio);
        }
    }

    public ResponseEntity<ColegioResponse> atualizarColegio(ColegioReqAtualizar colegioReqAtualizar, Long idColegio) {
        var colegioAtual = colegioRepository.findById(idColegio).orElseThrow(
                () -> new IdDoColegioNaoExisteException(idColegio));
        if (colegioReqAtualizar.getNomeColegio() == null) {
            colegioReqAtualizar.setNomeColegio(colegioAtual.getNomeColegio());
        }
        if (colegioReqAtualizar.getIdCidade() == null) {
            colegioReqAtualizar.setIdCidade(colegioAtual.getCidade().getIdCidade());
        }
        if (colegioReqAtualizar.getQtdAtualAlunos() == null) {
            colegioReqAtualizar.setQtdAtualAlunos(colegioAtual.getQtdAtualAlunos());
        }
        if (colegioReqAtualizar.getInfraestrutura() == null) {
            colegioReqAtualizar.setInfraestrutura(InfraestruturaRequest.builder()
                    .adaptadoPCD(colegioAtual.getInfraestrutura().getAdaptadoPCD())
                    .agua(colegioAtual.getInfraestrutura().getAgua())
                    .aguaPotavel(colegioAtual.getInfraestrutura().getAguaPotavel())
                    .computador(colegioAtual.getInfraestrutura().getComputador())
                    .eletricidade(colegioAtual.getInfraestrutura().getEletricidade())
                    .internet(colegioAtual.getInfraestrutura().getInternet())
                    .build());
        }
        var colegio = colegioReqAtualizar.convert(cidadeRepository, idColegio);
        colegioRepository.save(colegio);
        return ResponseEntity.ok(new ColegioResponse(colegio));
    }
}
