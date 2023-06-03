import { Injectable } from '@angular/core';
import { CabeceraInventario } from '../modelos/CabeceraInventario';
import { HttpClient } from '@angular/common/http';
import { CabeceraInventarioCreate } from '../modelos/CabeceraInventarioCreate';
import { CabeceraInventarioUpdate } from '../modelos/CabeceraInventarioUpdate';


@Injectable({
  providedIn: 'root'
})
export class CabeceraInventarioService {

    url:string = 'http://localhost:8080/api/cabeceraInventario/';

    constructor(private httpClient:HttpClient) { }
  
    getObtenerListaDeCabecerasInventario(){
      return this.httpClient.get<CabeceraInventario[]>(this.url);
    
  }

  registrarCabeceraInventario(cabeceraInventarioCreate:CabeceraInventarioCreate) { 
    return this.httpClient.post<CabeceraInventarioCreate>(this.url,cabeceraInventarioCreate);
  }

  obtenerCabeceraInventario(id:number){
    return this.httpClient.get<CabeceraInventarioUpdate>(this.url+"/"+id);
  }

  actualizarCabeceraInventario(cabeceraInventarioUpdate:CabeceraInventarioUpdate){
    return this.httpClient.put<CabeceraInventarioUpdate>(this.url, cabeceraInventarioUpdate);
  }

  deleteCabeceraInventario(CabeceraInventario:CabeceraInventario){
    return this.httpClient.delete<CabeceraInventario>(this.url+"/"+CabeceraInventario.id_cab_inventario);
  }


  
}
