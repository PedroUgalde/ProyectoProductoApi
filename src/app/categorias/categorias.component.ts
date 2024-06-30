import { Categoria } from './../model/Categoria';
import { Component, inject } from '@angular/core';
import { CommonModule} from '@angular/common';
import Swal from 'sweetalert2';
import { CategoriaService } from '../service/categoria.service';
import { HttpClient } from '@angular/common/http';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-categorias',
  standalone: true,
  imports: [CommonModule , RouterLink ],
  templateUrl: './categorias.component.html',
  styleUrl: './categorias.component.css'
})
export class CategoriasComponent {
  titulo: string='Listado de categorias';
  listaDeCategorias : Categoria[] =[];

  constructor(private categoriaService: CategoriaService){}
  httClient= inject(HttpClient);

  ngOnInit():void{
    this.categoriaService
    .mostrarCategorias()
    .subscribe(
      (lasCategorias) => (this.listaDeCategorias= lasCategorias) 
    );
  }
    /*[
      {
        idCategoria: 1,
        nombreCategoria: "Deportes",
        descripcionCategoria: "Articulos deportivos"
       },
       {
         idCategoria: 2,
         nombreCategoria: "Linea blanca",
         descripcionCategoria: "Articulos de linea blanca"
        },
        {
          idCategoria: 3,
          nombreCategoria: "Computo",
          descripcionCategoria: "Articulos de computo"
         },
         {
          idCategoria: 4,
          nombreCategoria: "Ropa",
          descripcionCategoria: "Articulos de ropa"
         },
         {
          idCategoria: 5,
          nombreCategoria: "Electronica",
          descripcionCategoria: "Articulos de electronica"
         }

    ];*/
    
    delete(categoria : Categoria): void{
      Swal.fire({
        title: "Estas Seguro?",
        text: "Se perdera la categoria para siempre",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, borralo"
      }).then((result) => {
        if (result.isConfirmed) {
          this.categoriaService
          .eliminarCategoria(categoria.idCategoria)
          .subscribe((response)=>this.categoriaService
            .mostrarCategorias()
            .subscribe((lasCategorias) => (this.listaDeCategorias)))
          Swal.fire({
            title: "Eliminado!",
            text: `El registro: ${categoria.nombreCategoria} se elimino satisfactoriamente.`,
            icon: "success"
          });
        }
      });
    }
  
    update(): void{
      Swal.fire("Actualizar Registro");
    }
}
