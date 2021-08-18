package br.com.letscode.infraestrutraescolareevasaoescolarapi.request.atualizar;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import lombok.Data;

@Data
public class CidadeReqAtualizar {
    private String nome;
    private String estado;
    private Long populacao;

    public Cidade convert(Long idCidade){
        return Cidade.builder().idCidade(idCidade).nomeCidade(nome).estado(estado).populacao(populacao).build();
    }
}
