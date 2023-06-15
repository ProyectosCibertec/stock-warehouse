import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CabeceraInventarioService } from '../../servicios/cabecera-inventario.service';
import { Empleado } from 'src/app/empleado/modelos/Empleado';
import { CabeceraInventario } from '../../modelos/CabeceraInventario';
import { EmpleadoService } from 'src/app/empleado/servicios/empleado.service';

@Component({
  selector: 'app-registrar-cabecera-inventario',
  templateUrl: './registrar-cabecera-inventario.component.html',
  styleUrls: ['./registrar-cabecera-inventario.component.css']
})
export class RegistrarCabeceraInventarioComponent implements OnInit {

empleados?:Empleado[];
modelCabeceraInventario = new CabeceraInventario();

constructor(private router: Router, private cabeceraInventarioService: CabeceraInventarioService, private empleadoService:EmpleadoService){}
  ngOnInit(): void {
    this.getEmpleados();
  }

  guardarCabeceraInventario( cabeceraInventario: CabeceraInventario) {
    this.cabeceraInventarioService.registrarCabeceraInventario(cabeceraInventario).subscribe(data => {
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
