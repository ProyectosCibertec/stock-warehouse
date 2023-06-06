import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private router: Router, private ordencompraService: OrdenCompraService, private proveedorService: ProveedorService) { }
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
      this.router.navigate(['ordencompra']);
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
}
