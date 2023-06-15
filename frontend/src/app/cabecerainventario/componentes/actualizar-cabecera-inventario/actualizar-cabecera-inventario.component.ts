import { Component, OnInit } from '@angular/core';
import { CabeceraInventarioService } from '../../servicios/cabecera-inventario.service';
import { Router } from '@angular/router';
import { EmpleadoService } from 'src/app/empleado/servicios/empleado.service';
import { CabeceraInventario } from '../../modelos/CabeceraInventario';

import { Empleado } from 'src/app/empleado/modelos/Empleado';

@Component({
  selector: 'app-actualizar-cabecera-inventario',
  templateUrl: './actualizar-cabecera-inventario.component.html',
  styleUrls: ['./actualizar-cabecera-inventario.component.css']
})
export class ActualizarCabeceraInventarioComponent implements OnInit {

 

  empleados?:Empleado[];
  cabeceraInventario = new CabeceraInventario();

  constructor(private router: Router, private cabecerainventarioService: CabeceraInventarioService, private empleadoService:EmpleadoService){}
  ngOnInit(): void {
    this.getEmpleados();
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.cabecerainventarioService.obtenerCabeceraInventario(id).subscribe(
      data=>{this.cabeceraInventario = data;
      });
  }

  actualizarCabeceraInventario(cabeceraInventario:CabeceraInventario){
    this.cabecerainventarioService.actualizarCabeceraInventario(cabeceraInventario).subscribe(dato=>{
      this.cabeceraInventario = dato;
      this.router.navigate(['cabecerasInventario']);
    });

}

getEmpleados(){
  this.empleadoService.getEmpleados().subscribe(
    data=>{
      this.empleados=data;
      console.log(data);
    },
    error=>{
      console.log(error);
    }
  );
}

}
