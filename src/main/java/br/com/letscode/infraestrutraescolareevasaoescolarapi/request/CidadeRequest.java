package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import lombok.Data;


@Data
public class CidadeRequest {

    private String nome;
    private String estado;
    private Long populacao;

    public Cidade convert(){
        return Cidade.builder().nomeCidade(nome).estado(estado).populacao(populacao).build();
    }
}
