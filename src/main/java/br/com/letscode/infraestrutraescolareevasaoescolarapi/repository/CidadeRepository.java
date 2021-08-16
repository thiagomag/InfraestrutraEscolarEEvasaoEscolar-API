package br.com.letscode.infraestrutraescolareevasaoescolarapi.repository;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNomeCidade(String nomeCidade);

    List<Cidade> findByIdCidade(Integer idCidade);
}
