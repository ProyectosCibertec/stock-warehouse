import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../../modelos/Empleado';
import { EmpleadoService } from '../../servicios/empleado.service';

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css']
})
export class ActualizarEmpleadoComponent implements OnInit{

  empleado: Empleado= new Empleado();
  constructor( private router:Router, private empleadoService:EmpleadoService) { }

  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id= JSON.parse(localStorage.getItem('id') as string);
    this.empleadoService.getEmpleadoId(id).subscribe(data=>{
      this.empleado=data;
    });
  }

  actualizar(empleado:Empleado){
    this.empleadoService.updateEmpleado(empleado).subscribe(data=>{
        this.empleado=data;
        this.router.navigate(['empleados']);
    });
  }

}
