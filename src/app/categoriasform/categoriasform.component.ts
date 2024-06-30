import { Categoria } from './../model/Categoria';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { CategoriaService } from '../service/categoria.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-categoriasform',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './categoriasform.component.html',
  styleUrls: ['./categoriasform.component.css']
})
export class CategoriasformComponent implements OnInit {
  
  titulo: string = 'Datos de la Categorias';
  categoria: Categoria = new Categoria();

  constructor(
    private categoriaService: CategoriaService, 
    private router: Router,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.mostrarCategoria();
  }

  mostrarCategoria(): void {
    this.rutaActiva.params.subscribe(parametro => {
      let id = parametro['id'];
      if (id) {
        this.categoriaService.mostrarCategoria(id).subscribe(
          (laCategoria) => (this.categoria = laCategoria)
        );
      }
    });
  }

  registrarCategoria(): void {
    this.categoriaService.crearCategoria(this.categoria).subscribe(() => {
      this.router.navigate(['/categorias']);
      Swal.fire('Nueva Categoria', 'Categoria creada con exito', 'success');
    });
  }

  actualizarCategoria(): void {
    Swal.fire('actualizado');
  }
}
