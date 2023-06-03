import { Component, OnInit } from '@angular/core';
import { CabeceraInventarioService } from '../../servicios/cabecera-inventario.service';
import { CabeceraInventario } from '../../modelos/CabeceraInventario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-cabecera-inventario',
  templateUrl: './listar-cabecera-inventario.component.html',
  styleUrls: ['./listar-cabecera-inventario.component.css']
})
export class ListarCabeceraInventarioComponent implements OnInit {

  
  cabecerasInventario?:CabeceraInventario[];
  //cabecerasInventario: any[] = [];

  constructor(private cabeceraInventarioService:CabeceraInventarioService, private router:Router){
    this.cabecerasInventario=[];
  }

  ngOnInit(): void {
    this.getObtenerCabecerasInventario();
  }

 private getObtenerCabecerasInventario(){
    this.cabeceraInventarioService.getObtenerListaDeCabecerasInventario().subscribe(
      data =>{
        this.cabecerasInventario = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  nuevaCabeceraInventario():void {
    this.router.navigate(['nuevaCabeceraInventario']);
  }

  editarCabeceraInventario(cabeceraInventario:CabeceraInventario):void {
    localStorage.setItem('id', cabeceraInventario.id_cab_inventario.toString());
    this.router.navigate(['editarCabeceraInventario']);
  }
  
  eliminarCabeceraInventario(cabeceraInventario:CabeceraInventario):void {
    this.cabeceraInventarioService.deleteCabeceraInventario(cabeceraInventario).subscribe(
      data=>{this.cabecerasInventario=this.cabecerasInventario!.filter(p=>p!==cabeceraInventario)}
    )
  }
}


