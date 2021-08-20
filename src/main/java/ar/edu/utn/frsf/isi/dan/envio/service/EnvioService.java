package ar.edu.utn.frsf.isi.dan.envio.service;

import java.util.List;

import ar.edu.utn.frsf.isi.dan.envio.model.Envio;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
public interface EnvioService
{
	Envio guardarEnvio(Envio envio);

	Envio actualizarEnvio(Envio envio, Long id);

	Envio obtenerEnvioPorId(Long id);

	List<Envio> listarEnvios();
}
