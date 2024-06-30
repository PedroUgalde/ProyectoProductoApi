import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-actividades',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './actividades.component.html',
  styleUrl: './actividades.component.css'
})
export class ActividadesComponent {
  titulo: string = 'operaciones Basicas';
  numeroUno : number =5;
  numeroDos : number =4;
  resultado: number =0;

  sumar(): void{
    this.resultado =this.numeroUno+this.numeroDos;
    console.log(this.resultado)
  }

  restar(): void{
    this.resultado =this.numeroUno-this.numeroDos;
  }

  multiplicar(): void{
    this.resultado =this.numeroUno*this.numeroDos;
  }

  dividir(): void{
    this.resultado =this.numeroUno/this.numeroDos;
  }
}
