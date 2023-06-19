import { Injectable } from '@angular/core';
import { DetalleOrdenCompra } from '../modelos/DetalleOrdenCompra';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DetalleOrdenCompraService {

  url:string = 'http://localhost:8080/api/detallesOrdenCompra/';

  constructor(private httpClient:HttpClient) { }

  getObtenerListaDetalleOrdenesCompra(){
    return this.httpClient.get<DetalleOrdenCompra[]>(this.url);
  
}

obtenerOrdenCompra(id:number){
  return this.httpClient.get<DetalleOrdenCompra>(this.url+"/"+id);
}

actualizarOrdenCompra(detalleOrdenCompra:DetalleOrdenCompra){
  return this.httpClient.put<DetalleOrdenCompra>(this.url, detalleOrdenCompra);
}

deleteDetalleOrdenCompra(detalleOrdenCompra:DetalleOrdenCompra){
  return this.httpClient.delete<DetalleOrdenCompra>(this.url+"/"+detalleOrdenCompra.id_detalle_orden);
}
}
