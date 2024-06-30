import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-conversiones',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './conversiones.component.html',
  styleUrl: './conversiones.component.css'
})
export class ConversionesComponent {

  titulo: string = 'Tabla de conversiones :)';
  Grado: number = 0;
  Resultado: number =0;



  CelsisuAFarenheith(): void{
    this.Resultado =(this.Grado*(9/5))+32;
    console.log(this.Resultado)
  }
  CelsisuAKelvin(): void{
    this.Resultado =(this.Grado+273.15);
    console.log(this.Resultado)
  }

  FarenheithACelsius(): void{
    this.Resultado =(this.Grado-32)*(5/9);
    console.log(this.Resultado)
  }
  FarenheithAKelvin(): void{
    this.Resultado =(this.Grado-32)*(5/9)+273.15;
    console.log(this.Resultado)
  }

  KelvinACelsius(): void{
    this.Resultado =(this.Grado-273.15);
    console.log(this.Resultado)
  }
  KelvinAFarenheith(): void{
    this.Resultado =(this.Grado-459.67);
    console.log(this.Resultado)
  }
  
}
