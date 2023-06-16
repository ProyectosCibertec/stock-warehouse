import { Injectable } from '@angular/core';
import { Usuario } from '../modelos/Usuario';
import { HttpClient } from '@angular/common/http';
import { TipoUsuario } from 'src/app/tipo-usuario/modelos/Tipo-usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url:string = 'http://localhost:8080/api/usuario/';


  constructor(private httpClient:HttpClient) { }
  
  getObtenerListaDeUsuario(){
    return this.httpClient.get<Usuario[]>(this.url);
}

registrarUsuario(usuario:Usuario) { 
  return this.httpClient.post<Usuario>(this.url,usuario);
}

obtenerUsuario(id:number){
  return this.httpClient.get<Usuario>(this.url+id);
}

actualizarUsuario(usuario:Usuario){
  return this.httpClient.put<Usuario>(this.url, usuario);
}

deleteUsuario(Usuario:Usuario){
  return this.httpClient.delete<Usuario>(this.url+Usuario.id_usuario);
} 

getObtenerListaDeTiposUsuario(){
  return this.httpClient.get<TipoUsuario[]>(this.url);
}
}

