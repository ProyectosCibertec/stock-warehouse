import { Component, OnInit } from '@angular/core';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { Router } from '@angular/router';
import { ProveedorService } from 'src/app/proveedor/servicios/proveedor.service';
import { Proveedor } from 'src/app/proveedor/modelos/Proveedor';
import { OrdenCompra } from '../../modelos/OrdenCompra';

@Component({
  selector: 'app-actualizar-orden-compra',
  templateUrl: './actualizar-orden-compra.component.html',
  styleUrls: ['./actualizar-orden-compra.component.css']
})
export class ActualizarOrdenCompraComponent implements OnInit {

   proveedores?:Proveedor[];
   ordenCompra = new OrdenCompra();
   
  constructor(private router: Router, private ordencompraService: OrdenCompraService,private proveedorService:ProveedorService){}
  ngOnInit(): void {
    this.getProveedores();
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.ordencompraService.obtenerOrdenCompra(id).subscribe(
      data=>{this.ordenCompra = data;
      });
  }

  actualizarOrdenCompra(ordenCompra:OrdenCompra){
    this.ordencompraService.actualizarOrdenCompra(ordenCompra).subscribe(dato=>{
      this.ordenCompra = dato;
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
