import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarEmpleadoComponent } from './page/listar/listar-empleado.component';
import { RegistrarEmpleadoComponent } from './page/registrar/registrar-empleado.component';
import { ActualizarEmpleadoComponent } from './page/actualizar/actualizar-empleado.component';

const routes: Routes = [
  {
    path: '',
    component: ListarEmpleadoComponent
  },
  {
    path: 'registrar',
    component: RegistrarEmpleadoComponent
  },
  {
    path: 'actualizar/:id',
    component: ActualizarEmpleadoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpleadoRoutingModule { }
