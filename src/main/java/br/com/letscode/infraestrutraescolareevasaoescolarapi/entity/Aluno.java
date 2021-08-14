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
import javax.persistence.Table;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "id_aluno")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAluno;
    @Column(name = "nome_aluno")
    private String nomeAluno;
    @ManyToOne
    @JoinColumn(name = "id_colegio", referencedColumnName = "id_colegio")
    private Colegio colegio;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "serie_escolar_atual")
    private String serieEscolarAtual;
    @Column(name = "concluiu_estudos")
    private Boolean concluiuEstudos;
    @Column(name = "eh_estudante")
    private Boolean ehEstudante;

    public Aluno(String nomeAluno, Colegio colegio, LocalDate dataNascimento, String serieEscolarAtual, Boolean concluiuEstudos, Boolean ehEstudante) {
        this.nomeAluno = nomeAluno;
        this.colegio = colegio;
        this.dataNascimento = dataNascimento;
        this.serieEscolarAtual = serieEscolarAtual;
        this.concluiuEstudos = concluiuEstudos;
        this.ehEstudante = ehEstudante;
    }
}
