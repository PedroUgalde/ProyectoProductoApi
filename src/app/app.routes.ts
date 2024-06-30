import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ActividadesComponent } from './actividades/actividades.component';
import { ConversionesComponent } from './conversiones/conversiones.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { CategoriasformComponent } from './categoriasform/categoriasform.component';

export const routes: Routes = [
    {path: '',redirectTo: '/home', pathMatch:'full'},
    {path:'home', component:HomeComponent},
    {path: 'actividades',component:ActividadesComponent},
    {path: 'conversiones',component:ConversionesComponent},
    {path: 'categorias',component:CategoriasComponent},
    {path: 'categoriasForm',component:CategoriasformComponent},
    {path: 'categoriasForm/:id',component:CategoriasformComponent},
];
