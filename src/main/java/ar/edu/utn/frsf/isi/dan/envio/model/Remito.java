package ar.edu.utn.frsf.isi.dan.envio.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "REMITO", schema = "MS_ENVIO")
public class Remito
{
	@Id
	@SequenceGenerator(name = "remitoGenerator", sequenceName = "SECUENCIA_REMITO", schema = "MS_ENVIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "remitoGenerator")
	@Column(name = "ID")
	private Long id;
	@Column(name = "NUMERO")
	private Long numero;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getNumero()
	{
		return numero;
	}

	public void setNumero(Long numero)
	{
		this.numero = numero;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, numero);
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
		Remito other = (Remito) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString()
	{
		return "Remito [id=" + id + ", numero=" + numero + "]";
	}

}
