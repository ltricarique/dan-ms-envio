package ar.edu.utn.frsf.isi.dan.envio.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.Immutable;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Immutable
@Table(name = "ESTADO_CAMION", schema = "MS_ENVIO")
public class EstadoCamion
{
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "ESTADO")
	private String estado;

	@Transient
	public static final Long LIBRE = 1L;
	@Transient
	public static final Long EN_VIAJE = 2L;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoCamion other = (EstadoCamion) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "EstadoPedido [id=" + id + ", estado=" + estado + "]";
	}
}
