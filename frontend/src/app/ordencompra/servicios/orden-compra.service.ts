import { Injectable } from '@angular/core';
import { OrdenCompra } from '../modelos/OrdenCompra';
import { HttpClient } from '@angular/common/http';
import { OrdenCompraCreate } from '../modelos/OrdenCompraCreate';
import { OrdenCompraUpdate } from '../modelos/OrdenCompraUpdate';

@Injectable({
  providedIn: 'root'
})
export class OrdenCompraService {

    url:string = 'http://localhost:8080/api/ordenCompra/';

    constructor(private httpClient:HttpClient) { }
  
    getObtenerListaDeOrdenesCompra(){
      return this.httpClient.get<OrdenCompra[]>(this.url);
    
  }

  registrarOrdenCompra(ordenCompraCreate:OrdenCompraCreate) { 
    return this.httpClient.post<OrdenCompraCreate>(this.url,ordenCompraCreate);
  }

  obtenerOrdenCompra(id:number){
    return this.httpClient.get<OrdenCompraUpdate>(this.url+"/"+id);
  }

  actualizarOrdenCompra(ordenCompraUpdate:OrdenCompraUpdate){
    return this.httpClient.put<OrdenCompraUpdate>(this.url, ordenCompraUpdate);
  }

  deleteOrdenCompra(OrdenCompra:OrdenCompra){
    return this.httpClient.delete<OrdenCompra>(this.url+"/"+OrdenCompra.id_orden_compra);
  }


  
}
