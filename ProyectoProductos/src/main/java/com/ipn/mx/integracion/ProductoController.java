package com.ipn.mx.integracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.servicios.ProductoService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/apiProducto")
public class ProductoController {
	@Autowired
	ProductoService service;
	
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> mostrarProductos(){
		return service.findAll();
	}
	
	@GetMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Producto mostrarProducto(@PathVariable long id){
		return service.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto(@RequestBody Producto producto){
		return service.save(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable long id){
		service.deleteById(id);
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable long id){
		Producto p = service.findById(id);
		p.setNombreProducto(producto.getNombreProducto());
		p.setDescripcionProducto(producto.getDescripcionProducto());
		p.setExistenciaProducto(producto.getExistenciaProducto());
		p.setPrecio(producto.getPrecio());
		return service.save(p);
	}
}
