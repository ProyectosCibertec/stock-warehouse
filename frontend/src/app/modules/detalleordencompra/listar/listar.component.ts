import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleOrdenCompra } from 'src/app/data/schema/detalleordencompra';
import { OrdenCompra } from 'src/app/data/schema/ordencompra';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { DetalleOrdenCompraService } from 'src/app/data/service/detalle-orden-compra.service';
import { OrdenCompraService } from 'src/app/data/service/orden-compra.service';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent {
  ordenCompra = new OrdenCompra();
  proveedores?: Proveedor[];

  detallesOrdenCompra?: DetalleOrdenCompra[];

  constructor(private ordenCompraService: OrdenCompraService, private router: Router, private proveedorService: ProveedorService, private detallesOrdenCompraService: DetalleOrdenCompraService) {
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

  getProveedores() {
    this.proveedorService.getProveedores().subscribe(
      data => {
        this.proveedores = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  eliminarDetalleOrdeCompra(detalleOrdenCompra: DetalleOrdenCompra): void {
    this.detallesOrdenCompraService.deleteDetalleOrdenCompra(detalleOrdenCompra).subscribe(
      data => {
        this.detallesOrdenCompra = this.detallesOrdenCompra!.filter(p => p !== detalleOrdenCompra)
        this.verDetallesOrdenCompra();
        this.router.navigate(['detalle-orden-compra/ver-detalle']);
      }
    )
  }
}
