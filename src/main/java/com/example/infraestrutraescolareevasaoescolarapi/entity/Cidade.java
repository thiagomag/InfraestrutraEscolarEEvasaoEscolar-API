package com.example.infraestrutraescolareevasaoescolarapi.entity;

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

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;
    @Column(name = "nome_aluno")
    private String nomeAluno;
    private String estado;
    private Long populacao;
}
