package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Long> {

    List<Pais> findByOrderByNomePais();
}
