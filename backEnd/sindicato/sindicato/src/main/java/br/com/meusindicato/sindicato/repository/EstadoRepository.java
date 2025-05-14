package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.model.Estado;
import br.com.meusindicato.sindicato.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
    List<Estado> findByPais(Pais pais);
}
