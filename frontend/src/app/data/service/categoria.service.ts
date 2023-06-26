import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categoria } from '../schema/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  constructor(private http:HttpClient) { }
  
  url = 'http://localhost:8080/api/categoria';

  getCategorias(){
    return this.http.get<Categoria[]>(this.url);
  }

  createCategoria(categoria: Categoria){
    return this.http.post<Categoria>(this.url,categoria);
  }

  getCategoriaId(id:number){
    return this.http.get<Categoria>(this.url+"/"+id);
  }

  updateCategoria(categoria: Categoria){
    return this.http.put<Categoria>(this.url,categoria);
  }

  deleteCategoria(categoria: Categoria){
    return this.http.delete<Categoria>(this.url+"/"+categoria.id);
  }
}
