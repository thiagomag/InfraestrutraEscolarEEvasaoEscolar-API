package br.com.letscode.infraestrutraescolareevasaoescolarapi.request;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CidadeRequest {
    private Long idCidade;
    private String nome;
    private String estado;
    private Long populacao;

    public Cidade convert(){
        return new Cidade(idCidade, nome, estado, populacao);
    }
}
