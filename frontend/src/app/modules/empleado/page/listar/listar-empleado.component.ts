import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from 'src/app/data/schema/empleado';
import { EmpleadoService } from 'src/app/data/service/empleado.service';

@Component({
  selector: 'app-listar-empleado',
  templateUrl: './listar-empleado.component.html',
  styleUrls: ['./listar-empleado.component.css']
})
export class ListarEmpleadoComponent implements OnInit {
  empleados?: Empleado[];

  constructor(private empleadoService: EmpleadoService) { }

  ngOnInit(): void {
    this.listEmpleados()
  }

  listEmpleados(): void {
    this.empleadoService.getEmpleados().subscribe(
      data => {
        this.empleados = data
      },
      error => {
        console.log(error)
      }
    );
  }

  deleteEmpleado(empleado: Empleado): void {
    this.empleadoService.deleteEmpleado(empleado).subscribe(() => {
      this.empleados = this.empleados?.filter(e => e.id != empleado.id)
    });
  }
}
