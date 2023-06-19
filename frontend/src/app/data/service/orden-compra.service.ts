import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrdenCompra } from '../schema/ordencompra';

@Injectable({
  providedIn: 'root'
})
export class OrdenCompraService {

  url: string = 'http://localhost:8080/api/ordenCompra';

  constructor(private httpClient: HttpClient) { }

  getObtenerListaDeOrdenesCompra() {
    return this.httpClient.get<OrdenCompra[]>(this.url);
  }

  registrarOrdenCompra(ordenCompra: OrdenCompra) {
    return this.httpClient.post<OrdenCompra>(this.url, ordenCompra);
  }

  obtenerOrdenCompra(id: number) {
    return this.httpClient.get<OrdenCompra>(this.url + "/" + id);
  }

  actualizarOrdenCompra(ordenCompra: OrdenCompra) {
    return this.httpClient.put<OrdenCompra>(this.url, ordenCompra);
  }

  deleteOrdenCompra(OrdenCompra: OrdenCompra) {
    return this.httpClient.delete<OrdenCompra>(this.url + "/" + OrdenCompra.id_orden_compra);
  }

  obtenerDetallesOrdenCompraPorOrdenCompra(id:number){
    return this.httpClient.get<OrdenCompra>(this.url+"/ordendetalle/"+id);
  }
}

