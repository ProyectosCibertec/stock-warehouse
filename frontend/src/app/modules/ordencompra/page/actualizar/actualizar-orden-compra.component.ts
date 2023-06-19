import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { OrdenCompra } from 'src/app/data/schema/ordencompra';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { OrdenCompraService } from 'src/app/data/service/orden-compra.service';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-actualizar-orden-compra',
  templateUrl: './actualizar-orden-compra.component.html',
  styleUrls: ['./actualizar-orden-compra.component.css']
})
export class ActualizarOrdenCompraComponent implements OnInit {
  proveedores?: Proveedor[];
  ordenCompra = new OrdenCompra();

  constructor(private toastr: ToastrService, private router: Router, private ordencompraService: OrdenCompraService, private proveedorService: ProveedorService) { }
  ngOnInit(): void {
    this.getProveedores();
    this.editar();
  }

  editar() {
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.ordencompraService.obtenerOrdenCompra(id).subscribe(
      data => {
        this.ordenCompra = data;
      });
  }

  actualizarOrdenCompra(ordenCompra: OrdenCompra) {
    this.ordencompraService.actualizarOrdenCompra(ordenCompra).subscribe(dato => {
      this.ordenCompra = dato;
      this.mostrarMensaje("La orden de compra se actualizo correctamente", "success");
      this.router.navigate(['orden-compra']);
    },
      error => {
        this.mostrarMensaje("No se pudo actualizar la orden de compra. Inténtalo nuevamente.", "error");
      });
  }

  getProveedores() {
    this.proveedorService.getProveedores().subscribe(
      data => {
        this.proveedores = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  mostrarMensaje(mensaje: string, tipo: string): void {
    switch (tipo) {
      case 'success':
        this.toastr.success(mensaje, 'Éxito');
        break;
      case 'error':
        this.toastr.error(mensaje, 'Error');
        break;
      default:
        this.toastr.show(mensaje);
        break;
    }
  }
}
