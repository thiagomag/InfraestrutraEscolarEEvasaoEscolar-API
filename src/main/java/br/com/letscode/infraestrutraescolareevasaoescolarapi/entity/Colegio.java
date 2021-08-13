package br.com.letscode.infraestrutraescolareevasaoescolarapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Random;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colegio")
public class Colegio {

    @Id
    @Column(name = "id_colegio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColegio;
    private String nomeColegio;
    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    private Cidade cidade;
    private Integer qtdAtualAlunos;
    @OneToOne
    @JoinColumn(name = "id_infra", referencedColumnName = "id_infra")
    private Infraestrutura infraestrutura;

    public Colegio(String nomeColegio, Cidade cidade, Integer qtdAtualAlunos, Infraestrutura infraestrutura) {
        this.idColegio = new Random().nextLong();
        this.nomeColegio = nomeColegio;
        this.cidade = cidade;
        this.qtdAtualAlunos = qtdAtualAlunos;
        this.infraestrutura = infraestrutura;
    }
}
