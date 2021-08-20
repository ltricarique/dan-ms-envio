package ar.edu.utn.frsf.isi.dan.envio.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
@Entity
@Table(name = "CAMION", schema = "MS_ENVIO")
public class Camion
{
	@Id
	@SequenceGenerator(name = "camionGenerator", sequenceName = "SECUENCIA_CAMION", schema = "MS_ENVIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camionGenerator")
	@Column(name = "ID")
	private Long id;
	@Column(name = "MARCA")
	private String marca;
	@Column(name = "MODELO")
	private String modelo;
	@Column(name = "DOMINIO")
	private String dominio;
	@Column(name = "CHOFER")
	private String chofer;
	@Column(name = "CAPACIDAD")
	private BigDecimal capacidad;
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_CAMION_ID_ESTADO_ESTADO_CAMION_ID"))
	private EstadoCamion estado;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public String getModelo()
	{
		return modelo;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	public String getDominio()
	{
		return dominio;
	}

	public void setDominio(String dominio)
	{
		this.dominio = dominio;
	}

	public String getChofer()
	{
		return chofer;
	}

	public void setChofer(String chofer)
	{
		this.chofer = chofer;
	}

	public BigDecimal getCapacidad()
	{
		return capacidad;
	}

	public void setCapacidad(BigDecimal capacidad)
	{
		this.capacidad = capacidad;
	}

	public EstadoCamion getEstado()
	{
		return estado;
	}

	public void setEstado(EstadoCamion estado)
	{
		this.estado = estado;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(capacidad, chofer, dominio, estado, id, marca, modelo);
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
		Camion other = (Camion) obj;
		return Objects.equals(capacidad, other.capacidad) && Objects.equals(chofer, other.chofer) && Objects.equals(dominio, other.dominio)
			&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
			&& Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString()
	{
		return "Camion [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", dominio=" + dominio + ", chofer=" + chofer + ", capacidad="
			+ capacidad + ", estado=" + estado + "]";
	}

}
