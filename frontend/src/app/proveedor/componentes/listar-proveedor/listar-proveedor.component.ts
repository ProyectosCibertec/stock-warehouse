
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proveedor } from '../../modelos/Proveedor';
import { ProveedorService } from '../../servicios/proveedor.service';

@Component({
  selector: 'app-listar-proveedor',
  templateUrl: './listar-proveedor.component.html',
  styleUrls: ['./listar-proveedor.component.css']
})


export class ListarProveedorComponent implements OnInit{

  proveedores?:Proveedor[];

  constructor(private proveedorService:ProveedorService, private router:Router) { }

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

  nuevo():void{
    this.router.navigate(['registrarProveedor']);
  }

  editar(proveedor:Proveedor):void{
    localStorage.setItem("id",proveedor.id.toString());
    this.router.navigate(['actualizarProveedor']);
  }

  eliminar(proveedor:Proveedor):void{
    this.proveedorService.deleteProveedor(proveedor).subscribe(data=>{
          this.proveedores=this.proveedores!.filter(p=>p!=proveedor);
    });
  }
}

