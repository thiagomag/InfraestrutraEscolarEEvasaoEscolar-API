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
import javax.persistence.Table;
import java.util.Random;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "infraestrutura")
public class Infraestrutura {

    @Id
    @Column(name = "id_infra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfra;
    private Boolean eletricidade;
    private Boolean internet;
    private Boolean computador;
    @Column(name = "adaptado_pcd")
    private Boolean adaptadoPCD;
    private Boolean agua;
    @Column(name = "agua_potavel")
    private Boolean aguaPotavel;

    public Infraestrutura (Boolean eletricidade, Boolean internet, Boolean computador, Boolean adaptadoPCD, Boolean agua, Boolean aguaPotavel){
        this.eletricidade = eletricidade;
        this.internet = internet;
        this.computador = computador;
        this.adaptadoPCD = adaptadoPCD;
        this.agua = agua;
        this.aguaPotavel = aguaPotavel;
    }
}
