package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.NomeCidadeNaoExisteException;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.CidadeRequest;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar.CidadeReqAtualizar;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.CidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public List<CidadeResponse> buscarCidades(){
        return CidadeResponse.convert(cidadeRepository.findAll());
    }

    public ResponseEntity<?> buscarPorId(Long idCidade) {
        List<Cidade> cidade = cidadeRepository.findByIdCidade(idCidade);
        return cidadeRepository.findById(idCidade).isPresent()
                ? ResponseEntity.ok().body(new CidadeResponse(cidade.get(0)))
                : ResponseEntity.ok().body(new IdDaCidadeNaoExisteException(idCidade));
    }

    public ResponseEntity<?> buscarPorNomeCidade(String nomeCidade){
        return cidadeRepository.findByNomeCidade(nomeCidade).isEmpty()
                ? ResponseEntity.ok().body(new NomeCidadeNaoExisteException(nomeCidade))
                : ResponseEntity.ok().body(CidadeResponse.convert(cidadeRepository.findByNomeCidade(nomeCidade)));
    }

    public ResponseEntity<CidadeResponse> incluirCidade(CidadeRequest cidadeRequest, UriComponentsBuilder uriComponentsBuilder){
        Cidade cidade = cidadeRequest.convert();
        cidadeRepository.save(cidade);
        URI uri = uriComponentsBuilder.path("/cidades/{idCidade}").buildAndExpand(cidade.getIdCidade()).toUri();
        return ResponseEntity.created(uri).body(new CidadeResponse(cidade));
    }

    public ResponseEntity<?> atualizarCidadePorId(CidadeReqAtualizar cidadeReqAtualizar, Long idCidade){
        Cidade cidade = cidadeReqAtualizar.convert(idCidade);
        cidadeRepository.save(cidade);
        return cidadeRepository.findById(idCidade).isPresent()
                ? ResponseEntity.ok().body(new CidadeResponse(cidade))
                : ResponseEntity.ok().body(new IdDaCidadeNaoExisteException(idCidade));
    }

}
