package br.com.letscode.infraestrutraescolareevasaoescolarapi.response;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import java.util.List;
import java.util.stream.Collectors;

public class CidadeResponse {

    private String nome;
    private long populacao;
    private String estado;

    public CidadeResponse(Cidade cidade){
        this.nome = cidade.getNomeCidade();
        this.populacao = cidade.getPopulacao();
        this.estado = cidade.getEstado();
    }

    public List<CidadeResponse> convert(List<Cidade> cidades){
        return cidades.stream().map(CidadeResponse::new).collect(Collectors.toList());
    }
}
