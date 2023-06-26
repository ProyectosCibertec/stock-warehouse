import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cargo } from '../schema/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {
  constructor(private http:HttpClient) { }
  
  url = 'http://localhost:8080/api/cargo';

  getCargos(){
    return this.http.get<Cargo[]>(this.url);
  }

  createCargo(cargo: Cargo){
    return this.http.post<Cargo>(this.url,cargo);
  }

  getCargoId(id:number){
    return this.http.get<Cargo>(this.url+"/"+id);
  }

  updateCargo(cargo: Cargo){
    return this.http.put<Cargo>(this.url,cargo);
  }

  deleteCargo(cargo: Cargo){
    return this.http.delete<Cargo>(this.url+"/"+cargo.id);
  }
}
