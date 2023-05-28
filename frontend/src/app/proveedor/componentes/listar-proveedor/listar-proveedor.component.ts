
import { Component, OnInit } from '@angular/core';
import { Proveedor } from '../../modelos/Proveedor';
import { ProveedorService } from '../../servicios/proveedor.service';

@Component({
  selector: 'app-listar-proveedor',
  templateUrl: './listar-proveedor.component.html',
  styleUrls: ['./listar-proveedor.component.css']
})


export class ListarProveedorComponent implements OnInit{

  proveedores?:Proveedor[];

  constructor(private proveedorService:ProveedorService) { }

  ngOnInit(): void {
      
    this.proveedorService.getProveedores().subscribe(
        data=>{
          this.proveedores=data;
          console.log(data);
        },
        error=>{
          console.log(error);
        }
    );
  }
}

