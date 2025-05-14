package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    List<Cidade> findByEstado(Estado estado);
}
