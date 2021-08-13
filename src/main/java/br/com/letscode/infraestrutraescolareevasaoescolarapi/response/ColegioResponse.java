package br.com.letscode.infraestrutraescolareevasaoescolarapi.response;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class ColegioResponse {

    private Long idColegio;
    private String nomeColegio;
    private Cidade cidade;
    private Integer qtdAtualAlunos;
    private Infraestrutura infraestrutura;

    public ColegioResponse(Colegio colegio) {
        this.idColegio = colegio.getIdColegio();
        this.nomeColegio = colegio.getNomeColegio();
        this.cidade = colegio.getCidade();
        this.qtdAtualAlunos = colegio.getQtdAtualAlunos();
        this.infraestrutura = colegio.getInfraestrutura();
    }

    public static List<ColegioResponse> convert(List<Colegio> colegios) {
        return colegios.stream().map(ColegioResponse::new).collect(Collectors.toList());
    }
}
