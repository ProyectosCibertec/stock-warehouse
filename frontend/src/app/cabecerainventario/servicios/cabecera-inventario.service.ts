import { Injectable } from '@angular/core';
import { CabeceraInventario } from '../modelos/CabeceraInventario';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class CabeceraInventarioService {

    url:string = 'http://localhost:8080/api/cabeceraInventario/';

    constructor(private httpClient:HttpClient) { }
  
    getObtenerListaDeCabecerasInventario(){
      return this.httpClient.get<CabeceraInventario[]>(this.url);
    
  }

  registrarCabeceraInventario(cabeceraInventario:CabeceraInventario) { 
    return this.httpClient.post<CabeceraInventario>(this.url,cabeceraInventario);
  }

  obtenerCabeceraInventario(id:number){
    return this.httpClient.get<CabeceraInventario>(this.url+"/"+id);
  }

  actualizarCabeceraInventario(cabeceraInventario:CabeceraInventario){
    return this.httpClient.put<CabeceraInventario>(this.url, cabeceraInventario);
  }

  deleteCabeceraInventario(CabeceraInventario:CabeceraInventario){
    return this.httpClient.delete<CabeceraInventario>(this.url+"/"+CabeceraInventario.id_cab_inventario);
  }


  
}
