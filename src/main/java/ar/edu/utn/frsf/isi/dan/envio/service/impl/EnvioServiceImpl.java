package ar.edu.utn.frsf.isi.dan.envio.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frsf.isi.dan.envio.model.Envio;
import ar.edu.utn.frsf.isi.dan.envio.repository.EnvioRepository;
import ar.edu.utn.frsf.isi.dan.envio.service.EnvioService;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Service
public class EnvioServiceImpl implements EnvioService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EnvioServiceImpl.class);

	@Autowired
	private EnvioRepository envioRepository;

	@Override
	public Envio guardarEnvio(Envio envio)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Envio actualizarEnvio(Envio envio, Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Envio obtenerEnvioPorId(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Envio> listarEnvios()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
