import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './page/listar/listar.component';
import { RegistrarComponent } from './page/registrar/registrar.component';
import { ActualizarComponent } from './page/actualizar/actualizar.component';

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
    path: 'actualizar',
    component: ActualizarComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TipousuarioRoutingModule { }
