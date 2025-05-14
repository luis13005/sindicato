package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Long> {
}
