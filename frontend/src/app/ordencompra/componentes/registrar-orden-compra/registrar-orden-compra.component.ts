import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { OrdenCompra } from '../../modelos/OrdenCompra';
import { ProveedorService } from 'src/app/proveedor/servicios/proveedor.service';
import { Proveedor } from 'src/app/proveedor/modelos/Proveedor';

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
      this.router.navigate(['ordenesCompra']);
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
