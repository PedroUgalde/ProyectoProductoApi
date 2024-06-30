import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { Categoria } from '../model/Categoria';
import{map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  private urlEndPoint: string = 'http://localhost:8082/apiCategoria/categorias';
  private httpHeaders = new HttpHeaders(
    {
      ContentType:'application/json'
    }
  )
  constructor(private http: HttpClient) { }
  mostrarCategorias(): Observable<Categoria[]>{
    return this.http
    .get(this.urlEndPoint)
    .pipe(map((response) => response as Categoria[]));
  }

  mostrarCategoria(id: number):Observable<Categoria>{
    return this.http.get<Categoria>(`${this.urlEndPoint}/${id}`);
  }

  crearCategoria(categoria: Categoria):Observable<Categoria>{
    return this.http.post<Categoria>(this.urlEndPoint, categoria, {headers: this.httpHeaders,});
  }

  eliminarCategoria(id: number):Observable<Categoria>{
    return this.http.delete<Categoria>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders,});
  }

  actualizarCategoria(categoria: Categoria):Observable<Categoria>{
    return this.http.post<Categoria>(`${this.urlEndPoint}/${categoria.idCategoria}`, categoria, {headers: this.httpHeaders,});
  }
}

