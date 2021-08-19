package br.com.letscode.infraestrutraescolareevasaoescolarapi.repository;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Cidade;
import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Long> {

    List<Colegio> findByNomeColegio(String nomeColegio);
    List<Colegio> findColegioByCidade(Cidade cidade);
    List<Colegio> findColegioByCidade_Estado(String estado);
}
