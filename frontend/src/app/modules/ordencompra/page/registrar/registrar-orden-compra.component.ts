import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompra } from 'src/app/data/schema/ordencompra';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { OrdenCompraService } from 'src/app/data/service/orden-compra.service';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-registrar-orden-compra',
  templateUrl: './registrar-orden-compra.component.html',
  styleUrls: ['./registrar-orden-compra.component.css']
})
export class RegistrarOrdenCompraComponent implements OnInit {

  proveedores?:Proveedor[];
modelOrdenCompra = new OrdenCompra();

constructor(private router: Router, private ordenCompraService: OrdenCompraService,private proveedorService:ProveedorService){}
  ngOnInit(): void {
    
    this.getProveedores();
  }

  guardarOrdenCompra( ordenCompra: OrdenCompra) {
    this.ordenCompraService.registrarOrdenCompra(ordenCompra).subscribe(data => {
      this.router.navigate(['ordencompra']);
    });
  }

  getProveedores(){
    this.proveedorService.getProveedores().subscribe(
      data=>{
        this.proveedores=data;
        console.log(data);
      },
      error=>{
        console.log(error);
      }
);}
}
