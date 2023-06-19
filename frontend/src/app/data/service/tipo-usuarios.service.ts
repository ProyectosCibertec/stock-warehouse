import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipoUsuario } from '../schema/tipousuario';

@Injectable({
  providedIn: 'root'
})
export class TipoUsuarioService {

  url: string = 'http://localhost:8080/api/tipo-usuario';

  constructor(private httpClient: HttpClient) { }

  getObtenerListaDeTiposUsuario() {
    return this.httpClient.get<TipoUsuario[]>(this.url);
  }

  registrarTipoUsuario(tipoUsuario: TipoUsuario) {
    return this.httpClient.post<TipoUsuario>(this.url, tipoUsuario);
  }

  obtenerTipoUsuario(id: number) {
    return this.httpClient.get<TipoUsuario>(this.url + "/" + id);
  }

  actualizarTipoUsuario(tipoUsuario: TipoUsuario) {
    return this.httpClient.put<TipoUsuario>(this.url, tipoUsuario);
  }

  deleteTipoUsuario(TipoUsuario: TipoUsuario) {
    return this.httpClient.delete(this.url + "/" + TipoUsuario.idTipoUsuario);
  }
}

