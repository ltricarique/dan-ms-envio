package ar.edu.utn.frsf.isi.dan.envio.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "OBRA", schema = "MS_USUARIO")
public class Obra
{
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "LATITUD")
	private BigDecimal latitud;
	@Column(name = "LONGITUD")
	private BigDecimal longitud;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "SUPERFICIE")
	private BigDecimal superficie;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public BigDecimal getLatitud()
	{
		return latitud;
	}

	public void setLatitud(BigDecimal latitud)
	{
		this.latitud = latitud;
	}

	public BigDecimal getLongitud()
	{
		return longitud;
	}

	public void setLongitud(BigDecimal longitud)
	{
		this.longitud = longitud;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public BigDecimal getSuperficie()
	{
		return superficie;
	}

	public void setSuperficie(BigDecimal superficie)
	{
		this.superficie = superficie;
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
		Obra other = (Obra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString()
	{
		return "Obra [id=" + id + ", descripcion=" + descripcion + ", latitud=" + latitud + ", longitud=" + longitud + ", direccion=" + direccion
			+ ", superficie=" + superficie + "]";
	}

}
