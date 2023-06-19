import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { OrdenCompra } from '../../modelos/OrdenCompra';
import { ProveedorService } from 'src/app/proveedor/servicios/proveedor.service';
import { Proveedor } from 'src/app/proveedor/modelos/Proveedor';
import { MatTableDataSource } from '@angular/material/table';
import { DetalleOrdenCompra } from '../../modelos/DetalleOrdenCompra';
import { ProductoService } from 'src/app/producto/servicios/producto.service';
import { Producto } from 'src/app/producto/modelos/Producto';
import { ProductoModalComponent } from '../producto-modal/producto-modal.component';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-registrar-orden-compra',
  templateUrl: './registrar-orden-compra.component.html',
  styleUrls: ['./registrar-orden-compra.component.css']
})
export class RegistrarOrdenCompraComponent implements OnInit {
  columnas: string[] = ['producto.id','producto.descripcion','precio_unitario','cantidad', 'costo_detalleorden',  'estado','eliminar'];
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  pageSize = 3; 

  detallesDataSource: MatTableDataSource<DetalleOrdenCompra> = new MatTableDataSource<DetalleOrdenCompra>();


  proveedores?:Proveedor[];
  productos?:Producto[];
  modelOrdenCompra = new OrdenCompra();
  modeloDetalleOC = new DetalleOrdenCompra();

  productoSeleccionado: any;

  detalles: DetalleOrdenCompra[] = [];


  constructor(private toastr: ToastrService, private router: Router, private ordenCompraService: OrdenCompraService, private proveedorService:ProveedorService, private productoService:ProductoService, private dialog: MatDialog) {}
  
  ngOnInit(): void {
    this.getProveedores();
    this.getProductos();

    // Recuperar detalles almacenados en el local storage
    const storedDetalles = localStorage.getItem('detalles');
    if (storedDetalles) {
      this.detalles = JSON.parse(storedDetalles);
    }

    this.detallesDataSource.data = this.detalles;
    this.detallesDataSource.paginator = this.paginator;
  }

  guardarOrdenCompra(ordenCompra: OrdenCompra) {
    ordenCompra.ordenCompraDetalleDTOList = this.detalles; 
    this.ordenCompraService.registrarOrdenCompra(ordenCompra).subscribe(data => {
      this.mostrarMensaje("La orden de compra se registró correctamente", "success");
      this.router.navigate(['ordenesCompra']);

      // Borrar los detalles almacenados en el local storage
      localStorage.removeItem('detalles');
    },
    error => {
      this.mostrarMensaje("No se pudo registrar la orden de compra. Inténtalo nuevamente/Verifica los campos obligatorios", "error");
    });
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

  getProductos() {
    this.productoService.getProductos().subscribe(
      data => {
        this.productos = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  generarColumnas() {
    const detalle = new DetalleOrdenCompra();
    this.columnas = Object.keys(detalle);
  }

  agregarDetalle() {
    if (
      this.modeloDetalleOC.producto.id &&
      this.modeloDetalleOC.precio_unitario &&
      this.modeloDetalleOC.cantidad &&
      this.modeloDetalleOC.costo_detalleorden &&
      this.modeloDetalleOC.estado >= 0
    ) {
      const nuevoDetalle: DetalleOrdenCompra = {
        producto: {
          id: this.modeloDetalleOC.producto.id,
          descripcion: this.modeloDetalleOC.producto.descripcion
        },
        precio_unitario: this.modeloDetalleOC.precio_unitario,
        cantidad: this.modeloDetalleOC.cantidad,
        costo_detalleorden: this.modeloDetalleOC.costo_detalleorden,  
        estado: this.modeloDetalleOC.estado
      };

      this.detalles.push(nuevoDetalle);
      this.limpiarCamposDetalle();
      this.detallesDataSource = new MatTableDataSource<DetalleOrdenCompra>(this.detalles);
      this.calcularValorTotalOrden();

      // Guardar los detalles en el local storage
      localStorage.setItem('detalles', JSON.stringify(this.detalles));
    }
  }

  eliminarDetalle(detalle: DetalleOrdenCompra): void {
    const index = this.detallesDataSource.data.indexOf(detalle);
    if (index >= 0) {
      this.detallesDataSource.data.splice(index, 1);
      this.detallesDataSource._updateChangeSubscription();
      this.calcularValorTotalOrden();

      // Actualizar los detalles almacenados en el local storage
      localStorage.setItem('detalles', JSON.stringify(this.detalles));
    }
  }

  limpiarCamposDetalle() {
    this.modeloDetalleOC.producto.id = 0;
    this.modeloDetalleOC.producto.descripcion = " ";
    this.modeloDetalleOC.cantidad = 0;
    this.modeloDetalleOC.precio_unitario = 0;
    this.modeloDetalleOC.costo_detalleorden = 0;
    this.modeloDetalleOC.estado = 0;
  }

  obtenerNombreColumna(columna: string): any {
    if (columna === 'producto.id') {
      return 'Producto';
    } else if (columna === 'producto.descripcion') {
      return 'Descripción';
    } else if (columna === 'precio_unitario') {
      return 'Precio Unitario';
    } else if (columna === 'cantidad') {
      return 'Cantidad';
    } else if (columna === 'costo_detalleorden') {
      return 'Costo Detalle Orden';
    } else if (columna === 'estado') {
      return 'Estado';
    } else if (columna === 'eliminar') {
      return 'Eliminar';
    }
  }

  obtenerValorColumna(detalle: DetalleOrdenCompra, columna: string): any {
    if (columna === 'producto.id') {
      return detalle.producto.id;
    } else if (columna === 'producto.descripcion') {
      return detalle.producto.descripcion;
    } else if (columna === 'precio_unitario') {
      return detalle.precio_unitario;
    } else if (columna === 'cantidad') {
      return detalle.cantidad;
    } else if (columna === 'costo_detalleorden') {
      return detalle.costo_detalleorden;
    } else if (columna === 'estado') {
      return detalle.estado;
    } else if (columna === 'eliminar') {
      return null; 
    }
  }

  abrirModalProductos() {
    const dialogRef = this.dialog.open(ProductoModalComponent, {
      width: 'auto',
      data: { productoSeleccionado: this.productoSeleccionado }
    }); 

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.productoSeleccionado = result;
        this.modeloDetalleOC.producto.id = this.productoSeleccionado.id;
        this.modeloDetalleOC.producto.descripcion = this.productoSeleccionado.descripcion;
      }
    });
  }

  calcularValorDetalle(): void {
    const precio = parseFloat(this.modeloDetalleOC.precio_unitario.toString());
    const cantidad = parseFloat(this.modeloDetalleOC.cantidad.toString());
    if (!isNaN(precio) && !isNaN(cantidad)) {
      const valorDetalle = precio * cantidad;
      this.modeloDetalleOC.costo_detalleorden = valorDetalle;
    }
  }

  calcularValorTotalOrden(): void {
    let valorTotal = 0;
    this.detallesDataSource.data.forEach(detalle => {
      const valorDetalle = parseFloat(detalle.costo_detalleorden.toString());
      if (!isNaN(valorDetalle)) {
        valorTotal += valorDetalle;
      }
    });
    this.modelOrdenCompra.valortotal_orden = valorTotal;
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

  onPageChange(event: PageEvent) {
    this.detallesDataSource.paginator!.pageIndex = event.pageIndex;
  }
}
