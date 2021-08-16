package br.com.letscode.infraestrutraescolareevasaoescolarapi.response;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions.IdDaCidadeNaoExisteException;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class CidadeResponse {

    private String nome;
    private long populacao;
    private String estado;

    public CidadeResponse(Cidade cidade){
        this.nome = cidade.getNomeCidade();
        this.populacao = cidade.getPopulacao();
        this.estado = cidade.getEstado();
    }

    public static List<CidadeResponse> convert(List<Cidade> cidades){
        return cidades.stream().map(CidadeResponse::new).collect(Collectors.toList());
    }
}
