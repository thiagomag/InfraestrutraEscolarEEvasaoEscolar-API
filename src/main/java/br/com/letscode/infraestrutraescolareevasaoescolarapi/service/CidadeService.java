package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.repository.CidadeRepository;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.response.CidadeResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public List<CidadeResponse> buscarCidades(){
        return CidadeResponse.convert(cidadeRepository.findAll());
    }

    public CidadeResponse buscarPorId(Long idCidade){
        return new CidadeResponse(cidadeRepository.getById(idCidade));
    }

}
