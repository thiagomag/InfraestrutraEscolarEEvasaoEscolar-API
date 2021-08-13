package br.com.letscode.infraestrutraescolareevasaoescolarapi.repository;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Infraestrutura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InfraestruturaRepository extends JpaRepository<Infraestrutura, Long> {

    List<Infraestrutura> findByEletricidade(Boolean valor);

    List<Infraestrutura> findByInternet(Boolean valor);

    List<Infraestrutura> findByComputador(Boolean valor);

    List<Infraestrutura> findByadaptadoPCD(Boolean valor);

    List<Infraestrutura> findByAgua(Boolean valor);

    List<Infraestrutura> findByAguaPotavel(Boolean valor);
}
