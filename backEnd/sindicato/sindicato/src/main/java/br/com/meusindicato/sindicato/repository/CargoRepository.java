package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long> {
}
