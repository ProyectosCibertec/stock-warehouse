import { Component, OnInit } from '@angular/core';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { OrdenCompra } from '../../modelos/OrdenCompra';
import { Router } from '@angular/router';

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
    this.router.navigate(['nuevaOrdenCompra']);
  }

  editarOrdenCompra(ordenCompra:OrdenCompra):void {
    localStorage.setItem('id', ordenCompra.id_orden_compra.toString());
    this.router.navigate(['editarOrdenCompra']);
  }
  
  eliminarOrdeCompra(ordenCompra:OrdenCompra):void {
    this.ordenCompraService.deleteOrdenCompra(ordenCompra).subscribe(
      data=>{this.ordenesCompra=this.ordenesCompra!.filter(p=>p!==ordenCompra)}
    )
  }

}

