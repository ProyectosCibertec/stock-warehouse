import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpleadoRoutingModule } from './empleado-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';
import { ActualizarEmpleadoComponent } from './page/actualizar/actualizar-empleado.component';
import { RegistrarEmpleadoComponent } from './page/registrar/registrar-empleado.component';
import { ListarEmpleadoComponent } from './page/listar/listar-empleado.component';


@NgModule({
  declarations: [
    ActualizarEmpleadoComponent,
    RegistrarEmpleadoComponent,
    ListarEmpleadoComponent
  ],
  imports: [
    CommonModule,
    EmpleadoRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class EmpleadoModule { }
