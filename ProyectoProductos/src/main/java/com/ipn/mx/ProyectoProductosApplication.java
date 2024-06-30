package com.ipn.mx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.repositorios.CategoriaRepository;

@SpringBootApplication
public class ProyectoProductosApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoProductosApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//el builder te ahoora escribir c1 = new ctaegoria c1.set nombre categoria...
		/*Categoria c = Categoria.builder()
				//.idCategoria(5L) como es autoincrements esto es opcional
				.nombreCategoria("Celulares")
				.descripcionCategoria("Celulares Bonitos")
				.build();
		repository.save(c);*/
		
		System.out.println("Hola estoy funcionando");
		
	}

}
