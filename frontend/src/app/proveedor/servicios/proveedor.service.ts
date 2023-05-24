import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Proveedor } from '../modelos/Proveedor';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {


  constructor(private http:HttpClient) { }
  url = 'http://localhost:8080/api/proveedores';

  getProveedores(){
    return this.http.get<Proveedor[]>(this.url);
  }
}
