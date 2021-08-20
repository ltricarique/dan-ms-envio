package ar.edu.utn.frsf.isi.dan.envio.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "ENVIO", schema = "MS_ENVIO")
public class Envio
{
	@Id
	@SequenceGenerator(name = "envioGenerator", sequenceName = "SECUENCIA_ENVIO", schema = "MS_ENVIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "envioGenerator")
	@Column(name = "ID")
	private Long id;
	@OneToMany(mappedBy = "envio")
	private List<Pedido> detalle;
	@ManyToOne
	@JoinColumn(name = "ID_CAMION", foreignKey = @ForeignKey(name = "FK_ENVIO_ID_CAMION_TO_CAMION_ID"))
	private Camion camion;
	@OneToOne
	@JoinColumn(name = "ID_REMITO", foreignKey = @ForeignKey(name = "FK_ENVIO_ID_REMITO_TO_REMITO_ID"))
	private Remito remito;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public List<Pedido> getDetalle()
	{
		return detalle;
	}

	public void setDetalle(List<Pedido> detalle)
	{
		this.detalle = detalle;
	}

	public Camion getCamion()
	{
		return camion;
	}

	public void setCamion(Camion camion)
	{
		this.camion = camion;
	}

	public Remito getRemito()
	{
		return remito;
	}

	public void setRemito(Remito remito)
	{
		this.remito = remito;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(camion, detalle, id, remito);
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
		Envio other = (Envio) obj;
		return Objects.equals(camion, other.camion) && Objects.equals(detalle, other.detalle) && Objects.equals(id, other.id)
			&& Objects.equals(remito, other.remito);
	}

	@Override
	public String toString()
	{
		return "Envio [id=" + id + ", detalle=" + detalle + ", camion=" + camion + ", remito=" + remito + "]";
	}

}
