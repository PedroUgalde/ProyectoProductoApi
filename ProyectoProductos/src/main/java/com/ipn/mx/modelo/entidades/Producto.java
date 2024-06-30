package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Producto")

public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@NotBlank(message="El nombre es obligatoria")
	@Size(min=5,max=20,message="Debe de estar entre 5 y 20 caracteres")
	@Column(name="nombreProducto", length =50, nullable=false)
	private String nombreProducto;
	
	@NotBlank(message="La descripcion es obligatoria")
	@Size(min=5,max=250,message="Debe de estar entre 5 y 250 caracteres")
	@Column(name="descripcionProducto", length =50, nullable=false)
	private String descripcionProducto;
	
	@Column(name="existenciaProducto", nullable=false)
	private int existenciaProducto;
	@Column(name="precio", nullable=false)
	private double precio;
	
	@ManyToOne
	@JoinColumn(name= "idCategoria")
	@JsonBackReference
	private Categoria idCategoria;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public void setExistenciaProducto(int existenciaProducto) {
		this.existenciaProducto = existenciaProducto;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
}
