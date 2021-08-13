package br.com.letscode.infraestrutraescolareevasaoescolarapi.repository;

import br.com.letscode.infraestrutraescolareevasaoescolarapi.entity.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegioRepository extends JpaRepository<Colegio, Long> {
}
