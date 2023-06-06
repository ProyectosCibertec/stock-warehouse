import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompra } from 'src/app/data/schema/ordencompra';
import { OrdenCompraService } from 'src/app/data/service/orden-compra.service';

@Component({
  selector: 'app-listar-orden-compra',
  templateUrl: './listar-orden-compra.component.html',
  styleUrls: ['./listar-orden-compra.component.css']
})
export class ListarOrdenCompraComponent implements OnInit {
  
  ordenesCompra?:OrdenCompra[];
  ordencompra = new OrdenCompra();


  constructor(private ordenCompraService:OrdenCompraService, private router:Router){
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
    this.router.navigate(['ordencompra/registrar']);
  }

  editarOrdenCompra(ordenCompra:OrdenCompra):void {
    localStorage.setItem('id', ordenCompra.id_orden_compra.toString());
    this.router.navigate(['ordencompra/actualizar']);
  }
  
  eliminarOrdeCompra(ordenCompra:OrdenCompra):void {
    this.ordenCompraService.deleteOrdenCompra(ordenCompra).subscribe(
      data=>{this.ordenesCompra=this.ordenesCompra!.filter(p=>p!==ordenCompra)}
    )
  }

}


