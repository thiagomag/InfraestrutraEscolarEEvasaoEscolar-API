package br.com.letscode.infraestrutraescolareevasaoescolarapi.repository;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeAluno(String nomeAluno);

    List<Aluno> findByColegio_NomeColegio(String nomeColegio);

    @Query(value = "SELECT * FROM aluno WHERE YEAR (data_nascimento) = ?1", nativeQuery = true)
    List<Aluno> findByAnoNascimento(Integer ano);
}
