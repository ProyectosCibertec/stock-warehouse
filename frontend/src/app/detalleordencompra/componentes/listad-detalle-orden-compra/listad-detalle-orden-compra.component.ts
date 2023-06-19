import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompra } from 'src/app/ordencompra/modelos/OrdenCompra';
import { OrdenCompraService } from 'src/app/ordencompra/servicios/orden-compra.service';
import { DetalleOrdenCompra } from '../../modelos/DetalleOrdenCompra';
import { ProveedorService } from 'src/app/proveedor/servicios/proveedor.service';
import { Proveedor } from 'src/app/proveedor/modelos/Proveedor';
import { DetalleOrdenCompraService } from '../../servicios/detalle-orden-compra.service';


@Component({
  selector: 'app-listad-detalle-orden-compra',
  templateUrl: './listad-detalle-orden-compra.component.html',
  styleUrls: ['./listad-detalle-orden-compra.component.css']
})
export class ListadDetalleOrdenCompraComponent implements OnInit {

  ordenCompra = new OrdenCompra();
  proveedores?:Proveedor[];

  detallesOrdenCompra?:DetalleOrdenCompra[];

  constructor(private ordenCompraService:OrdenCompraService, private router:Router, private proveedorService:ProveedorService, private detallesOrdenCompraService:DetalleOrdenCompraService){
  }

  ngOnInit(): void {
    this.verDetallesOrdenCompra();
    this.getProveedores();
  }

  verDetallesOrdenCompra() {
    let id = localStorage.getItem('id');
  if (id) {
    this.ordenCompraService.obtenerDetallesOrdenCompraPorOrdenCompra(+id).subscribe(
      data => { 
        this.ordenCompra = data;
        this.detallesOrdenCompra = this.ordenCompra.ordenCompraDetalleDTOList;
        console.log(data);
        console.log(this.detallesOrdenCompra);
      },
      error => {
        console.log(error);
      }
    );
  } else {
    console.log('No se encontró el ID en localStorage');
  }
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

  eliminarDetalleOrdeCompra(detalleOrdenCompra:DetalleOrdenCompra):void {
    this.detallesOrdenCompraService.deleteDetalleOrdenCompra(detalleOrdenCompra).subscribe(
      data=>{this.detallesOrdenCompra=this.detallesOrdenCompra!.filter(p=>p!==detalleOrdenCompra)

        this.verDetallesOrdenCompra();
        this.router.navigate(['verDetallesOrdenCompra']);
      }
      
    )
  }

}
