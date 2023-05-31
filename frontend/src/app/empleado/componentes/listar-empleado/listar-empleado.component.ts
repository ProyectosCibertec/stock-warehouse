import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../../modelos/Empleado';
import { EmpleadoService } from '../../servicios/empleado.service';

@Component({
  selector: 'app-listar-empleado',
  templateUrl: './listar-empleado.component.html',
  styleUrls: ['./listar-empleado.component.css']
})
export class ListarEmpleadoComponent implements OnInit{

  empleados?:Empleado[];

  constructor(private empleadoService:EmpleadoService, private router:Router) { }

  ngOnInit(): void {
      
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

  nuevo():void{
    this.router.navigate(['registrarEmpleado']);
  }

  editar(empleado:Empleado):void{
    localStorage.setItem("id",empleado.id.toString());
    this.router.navigate(['actualizarEmpleado']);
  }

  eliminar(empleado:Empleado):void{
    this.empleadoService.deleteEmpleado(empleado).subscribe(data=>{
          this.empleados=this.empleados!.filter(p=>p!=empleado);
    });
  }

}
