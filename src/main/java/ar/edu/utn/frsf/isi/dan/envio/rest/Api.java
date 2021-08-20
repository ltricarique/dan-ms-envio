package ar.edu.utn.frsf.isi.dan.envio.rest;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
public interface Api
{
	String BASE_PATH = "/api/v1";

	String ENVIO_BASE_PATH = BASE_PATH + "/envio";
	String ENVIO_ID_GET_PATH = ENVIO_BASE_PATH + "/{id}";
	String ENVIO_ID_PUT_PATH = ENVIO_BASE_PATH + "/{id}";
	String ENVIO_GET_ALL_PATH = ENVIO_BASE_PATH + "/listar";
}
