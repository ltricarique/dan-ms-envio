package ar.edu.utn.frsf.isi.dan.envio.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "PEDIDO", schema = "MS_PEDIDO")
public class Pedido
{
	@Id
	@SequenceGenerator(name = "pedidoGenerator", sequenceName = "SECUENCIA_PEDIDO", schema = "MS_PEDIDO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidoGenerator")
	@Column(name = "ID")
	private Long id;
	@Column(name = "FECHA_PEDIDO")
	private Instant fechaPedido;
	@Column(name = "FECHA_ENVIO")
	private Instant fechaEnvio;
	@ManyToOne
	@JoinColumn(name = "ID_OBRA", foreignKey = @ForeignKey(name = "FK_PEDIDO_ID_OBRA_OBRA_ID"))
	private Obra obra;
	@OneToMany(mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<DetallePedido> detalle;
	@ManyToOne
	@JoinColumn(name = "ID_ENVIO", foreignKey = @ForeignKey(name = "FK_PEDIDO_ID_ENVIO_ENVIO_ID"))
	private Envio envio;
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_PEDIDO_ID_ESTADO_ESTADO_PEDIDO_ID"))
	private EstadoPedido estado;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Instant getFechaPedido()
	{
		return fechaPedido;
	}

	public void setFechaPedido(Instant fechaPedido)
	{
		this.fechaPedido = fechaPedido;
	}

	public Instant getFechaEnvio()
	{
		return fechaEnvio;
	}

	public void setFechaEnvio(Instant fechaEnvio)
	{
		this.fechaEnvio = fechaEnvio;
	}

	public Obra getObra()
	{
		return obra;
	}

	public void setObra(Obra obra)
	{
		this.obra = obra;
	}

	public List<DetallePedido> getDetalle()
	{
		return detalle;
	}

	public void setDetalle(List<DetallePedido> detalle)
	{
		this.detalle = detalle;
	}

	public EstadoPedido getEstado()
	{
		return estado;
	}

	public void setEstado(EstadoPedido estado)
	{
		this.estado = estado;
	}

	public Envio getEnvio()
	{
		return envio;
	}

	public void setEnvio(Envio envio)
	{
		this.envio = envio;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(detalle, envio, estado, fechaEnvio, fechaPedido, id, obra);
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
		Pedido other = (Pedido) obj;
		return Objects.equals(detalle, other.detalle) && Objects.equals(envio, other.envio) && Objects.equals(estado, other.estado)
			&& Objects.equals(fechaEnvio, other.fechaEnvio) && Objects.equals(fechaPedido, other.fechaPedido) && Objects.equals(id, other.id)
			&& Objects.equals(obra, other.obra);
	}

	@Override
	public String toString()
	{
		return "Pedido [id=" + id + ", fechaPedido=" + fechaPedido + ", fechaEnvio=" + fechaEnvio + ", obra=" + obra + ", detalle=" + detalle
			+ ", envio=" + envio + ", estado=" + estado + "]";
	}

}
