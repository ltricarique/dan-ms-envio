package ar.edu.utn.frsf.isi.dan.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frsf.isi.dan.envio.model.Envio;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long>
{

}
