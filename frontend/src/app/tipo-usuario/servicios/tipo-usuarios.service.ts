import { Injectable } from '@angular/core';
import { TipoUsuario } from '../modelos/Tipo-usuario';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class TipoUsuarioService {

    url:string = 'http://localhost:8080/api/tipo-usuario/';

    constructor(private httpClient:HttpClient) { }
  
    getObtenerListaDeTiposUsuario(){
      return this.httpClient.get<TipoUsuario[]>(this.url);
  }

  registrarTipoUsuario(tipoUsuario:TipoUsuario) { 
    return this.httpClient.post<TipoUsuario>(this.url,tipoUsuario);
  }

  obtenerTipoUsuario(id:number){
    return this.httpClient.get<TipoUsuario>(this.url+"/"+id);
  }

  actualizarTipoUsuario(tipoUsuario:TipoUsuario){
    return this.httpClient.put<TipoUsuario>(this.url, tipoUsuario);
  }

  deleteTipoUsuario(TipoUsuario:TipoUsuario){
    return this.httpClient.delete<TipoUsuario>(this.url+TipoUsuario.idTipoUsuario);
  } 
}

