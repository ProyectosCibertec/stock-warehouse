import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarComponent } from './page/actualizar/actualizar.component';
import { ListarComponent } from './page/listar/listar.component';
import { RegistrarComponent } from './page/registrar/registrar.component';

const routes: Routes = [
  {
    path: '',
    component: ListarComponent
  },
  {
    path: 'registrar',
    component: RegistrarComponent
  },
  {
    path: 'actualizar/:id',
    component: ActualizarComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CargoRoutingModule { }
