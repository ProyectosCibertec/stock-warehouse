import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proveedor } from '../../modelos/Proveedor';
import { ProveedorService } from '../../servicios/proveedor.service';

@Component({
  selector: 'app-actualizar-proveedor',
  templateUrl: './actualizar-proveedor.component.html',
  styleUrls: ['./actualizar-proveedor.component.css']
})
export class ActualizarProveedorComponent implements OnInit{

  proveedor: Proveedor= new Proveedor();
  constructor( private router:Router, private proveedorService:ProveedorService) { }

  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id= JSON.parse(localStorage.getItem('id') as string);
    this.proveedorService.getProveedorId(id).subscribe(data=>{
      this.proveedor=data;
    });
  }

  actualizar(proveedor:Proveedor){
    this.proveedorService.updateProveedor(proveedor).subscribe(data=>{
        this.proveedor=data;
        this.router.navigate(['proveedores']);
    });
  }

}
