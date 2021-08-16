package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
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

    public ResponseEntity<CidadeResponse> buscarPorId(Long idCidade) {
        Cidade cidade = cidadeRepository.getById(idCidade);
        return cidadeRepository.findById(idCidade).isPresent()
                ? ResponseEntity.ok().body(new CidadeResponse(cidade))
                : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<CidadeResponse>> buscarPorNomeCidade(String nomeCidade){
        if(cidadeRepository.findByNomeCidade(nomeCidade).isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok().body(CidadeResponse.convert(cidadeRepository.findByNomeCidade(nomeCidade)));
        }

    }

    public ResponseEntity<CidadeResponse> incluirCidade(CidadeRequest cidadeRequest, UriComponentsBuilder uriComponentsBuilder){
        Cidade cidade = cidadeRequest.convert();
        cidadeRepository.save(cidade);
        URI uri = uriComponentsBuilder.path("/cidades/{idCidade}").buildAndExpand(cidade.getIdCidade()).toUri();
        return ResponseEntity.created(uri).body(new CidadeResponse(cidade));
    }

    public ResponseEntity<CidadeResponse> atualizarCidadePorId(CidadeReqAtualizar cidadeReqAtualizar, Long idCidade){
        Cidade cidade = cidadeReqAtualizar.convert(idCidade);
        cidadeRepository.save(cidade);
        return cidadeRepository.findById(idCidade).isPresent()
                ? ResponseEntity.ok().body(new CidadeResponse(cidade))
                : ResponseEntity.notFound().build();
    }

}
