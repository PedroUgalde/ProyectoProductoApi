package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
//como se necesita esto en otros paquetes se agrega iplements serializable
//@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
//permite construir una clase a partir de sus atributos sin usar get y set
@Builder
//es una entidad la base
@Entity
@Table(name= "Categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// por cada atributo se necesita get y set
	// los datos deben ser iguales a la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	//si hay algo distiinto te hace un alter table
	@NotBlank(message="La descripcion es obligatoria")
	@Size(min=5,max=250,message="Debe de estar entre 5 y 250 caracteres")
	@Column(name="descripcionCategoria", length =50, nullable=false)
	private String descripcionCategoria;
	
	
	@Column(name="nombreCategoria", length =50, nullable=false)
	private String nombreCategoria;
	
	@JsonIgnoreProperties(value = {"idCategoria","hibernateLazyInitializer","handler"},
			allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idCategoria", cascade= CascadeType.ALL)
	//@JsonManagedReference
	private List<Producto> productos;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria; 
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
		for(Producto lista_productos: productos) {
			lista_productos.setIdCategoria(this);
		}
	}
	
	
}
