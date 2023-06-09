import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompra } from 'src/app/data/schema/ordencompra';
import { OrdenCompraService } from 'src/app/data/service/orden-compra.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-listar-orden-compra',
  templateUrl: './listar-orden-compra.component.html',
  styleUrls: ['./listar-orden-compra.component.css']
})
export class ListarOrdenCompraComponent implements OnInit {
  
  ordenesCompra?:OrdenCompra[];
  ordencompra = new OrdenCompra();

  constructor(private toastr: ToastrService,private ordenCompraService:OrdenCompraService, private router:Router){
    this.ordenesCompra=[];
  }

  ngOnInit(): void {
    this.getObtenerOrdenesdeCompra();
  }

 private getObtenerOrdenesdeCompra(){
    this.ordenCompraService.getObtenerListaDeOrdenesCompra().subscribe(
      data =>{ 
        this.ordenesCompra = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  nuevaOrdenCompra():void {
    this.router.navigate(['orden-compra/registrar']);
  }

  editarOrdenCompra(ordenCompra:OrdenCompra):void {
    localStorage.setItem('id', ordenCompra.id_orden_compra.toString());
    this.router.navigate(['orden-compra/actualizar']);
  }
  
  eliminarOrdeCompra(ordenCompra:OrdenCompra):void {
    this.ordenCompraService.deleteOrdenCompra(ordenCompra).subscribe(
      data=>{this.ordenesCompra=this.ordenesCompra!.filter(p=>p!==ordenCompra)
        this.mostrarMensaje("La orden de compra se ha eliminado correctamente", "success");
      },
      error => {
        this.mostrarMensaje("No se pudo eliminar la orden de compra. Inténtalo nuevamente/Verifique que no tenga detalles registrados.", "error");

      }
    )
  }


  verDetallesOrdenCompra(ordenCompra: OrdenCompra): void {
    localStorage.setItem('id', ordenCompra.id_orden_compra.toString());
    this.router.navigate(['detalle-orden-compra/ver-detalle']);
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


