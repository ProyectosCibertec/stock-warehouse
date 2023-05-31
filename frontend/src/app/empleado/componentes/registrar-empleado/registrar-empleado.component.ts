import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../../modelos/Empleado';
import { EmpleadoService } from '../../servicios/empleado.service';

@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css']
})
export class RegistrarEmpleadoComponent implements OnInit{

  modelEmpleado = new Empleado();
  constructor(private router:Router, private empleadoService:EmpleadoService) { }

  ngOnInit(): void {
  }

  guardar(empleado:Empleado){

    this.empleadoService.createEmpleado(empleado).subscribe( data=>{
        this.router.navigate(['empleados']);
    });
  }

}
