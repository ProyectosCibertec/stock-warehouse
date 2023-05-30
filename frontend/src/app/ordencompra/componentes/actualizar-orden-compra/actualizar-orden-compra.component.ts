import { Component, OnInit } from '@angular/core';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { Router } from '@angular/router';
import { OrdenCompra } from '../../modelos/OrdenCompra';
import { OrdenCompraUpdate } from '../../modelos/OrdenCompraUpdate';

@Component({
  selector: 'app-actualizar-orden-compra',
  templateUrl: './actualizar-orden-compra.component.html',
  styleUrls: ['./actualizar-orden-compra.component.css']
})
export class ActualizarOrdenCompraComponent implements OnInit {

  ordenCompraUpdate = new OrdenCompraUpdate();


  constructor(private router: Router, private ordencompraService: OrdenCompraService){}
  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.ordencompraService.obtenerOrdenCompra(id).subscribe(
      data=>{this.ordenCompraUpdate = data;
      });
  }

  actualizarOrdenCompra(ordenCompraUpdate:OrdenCompraUpdate){
    this.ordencompraService.actualizarOrdenCompra(ordenCompraUpdate).subscribe(dato=>{
      this.ordenCompraUpdate = dato;
      this.router.navigate(['ordenesCompra']);
    });

}

}
