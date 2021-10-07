package ar.edu.utn.frsf.isi.dan.envio.rest;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frsf.isi.dan.envio.exception.ArgumentoIlegalException;
import ar.edu.utn.frsf.isi.dan.envio.exception.RecursoNoEncontradoException;
import ar.edu.utn.frsf.isi.dan.envio.model.Envio;
import ar.edu.utn.frsf.isi.dan.envio.service.EnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@RestController
@RequestMapping(Api.ENVIO_BASE_PATH)
@CrossOrigin
@Tag(name = "EnvioRest", description = "Permite gestionar los envíos realizados por los empleados de la empresa.")
public class EnvioRest
{
	@Autowired
	private EnvioService envioService;

	@RolesAllowed(Role.CLIENTE)
	@PostMapping
	@Operation(summary = "Registra un nuevo envio.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Envío registrado correctamente"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado") })
	public ResponseEntity<?> registrar(@RequestBody Envio envio)
	{
		try
		{
			return ResponseEntity.ok(envioService.guardarEnvio(envio));
		}
		catch (ArgumentoIlegalException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch (RecursoNoEncontradoException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RolesAllowed(Role.EMPLEADO)
	@PutMapping(path = Api.ENVIO_ID_PUT_PATH)
	@Operation(summary = "Actualiza un envío.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Envío actualizado"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Envío inexistente") })
	public ResponseEntity<?> actualizar(@Parameter(description = "Pedido a actualizar") @RequestBody Envio envio,
		@Parameter(description = "Id del envío a actualizar") @PathVariable Long id)
	{
		try
		{
			return ResponseEntity.ok(envioService.actualizarEnvio(envio, id));
		}
		catch (ArgumentoIlegalException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch (RecursoNoEncontradoException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RolesAllowed(Role.EMPLEADO)
	@GetMapping(path = Api.ENVIO_ID_GET_PATH)
	@Operation(summary = "Retorna un envío por id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Envío recuperado"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Envío inexistente") })
	public ResponseEntity<?> obtenerPorId(@Parameter(description = "Id del envío a retornar") @PathVariable Long id)
	{
		try
		{
			return ResponseEntity.ok(envioService.obtenerEnvioPorId(id));
		}
		catch (ArgumentoIlegalException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch (RecursoNoEncontradoException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RolesAllowed(Role.EMPLEADO)
	@GetMapping(path = Api.ENVIO_GET_ALL_PATH)
	@Operation(summary = "Retorna todos los envíos registrados.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Envíos registrados"),
		@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "No existen envíos registrados") })
	public ResponseEntity<?> listar()
	{
		try
		{
			return ResponseEntity.ok(envioService.listarEnvios());
		}
		catch (ArgumentoIlegalException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch (RecursoNoEncontradoException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	/*
		@RolesAllowed(Role.EMPLEADO)
		@GetMapping(path = Api.ENVIO_GET_DETALLE_PATH)
		@Operation(summary = "Retorna todos los detalles de un envío registrado.")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Envíos registrados"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
			@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
			@ApiResponse(responseCode = "404", description = "No existen envíos registrados") })
		public ResponseEntity<?> listarDetalles(@Parameter(description = "Id del envío") @PathVariable Long idEnvio)
		{
			try
			{
				return ResponseEntity.ok(detalleEnvioService.obtenerDetalleEnvioPorId(idEnvio));
			}
			catch (ArgumentoIlegalException e)
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
			catch (RecursoNoEncontradoException e)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
			catch (Exception e)
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}
	*/

	@GetMapping(path = "/instancia")
	@Operation(summary = "Retorna información de la instancia.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información de la instancia"),
		@ApiResponse(responseCode = "401", description = "No autorizado"), @ApiResponse(responseCode = "403", description = "Prohibido"),
		@ApiResponse(responseCode = "404", description = "Recurso no encontrado") })
	public ResponseEntity<?> instancia()
	{
		return ResponseEntity.ok("dan-ms-envio -> [OK]");
	}
}
