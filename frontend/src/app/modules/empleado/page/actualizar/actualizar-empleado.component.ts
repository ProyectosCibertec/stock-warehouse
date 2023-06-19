import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Empleado } from 'src/app/data/schema/empleado';
import { EmpleadoService } from 'src/app/data/service/empleado.service';

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css']
})
export class ActualizarEmpleadoComponent implements OnInit {
  empleado: Empleado = new Empleado();

  constructor(
    private router: Router,
    private empleadoService: EmpleadoService, 
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getEmpleado();
  }

  getEmpleado() {
    let id = Number(this.route.snapshot.paramMap.get('id'));
    this.empleadoService.getEmpleadoId(id).subscribe(data => {
      this.empleado = data;
    });
  }

  update(empleado: Empleado) {
    this.empleadoService.updateEmpleado(empleado).subscribe(data => {
      this.empleado = data;
      this.router.navigate(['empleado']);
    });
  }
}
