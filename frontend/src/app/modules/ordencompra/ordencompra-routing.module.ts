import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarOrdenCompraComponent } from './page/listar/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './page/registrar/registrar-orden-compra.component';
import { ActualizarOrdenCompraComponent } from './page/actualizar/actualizar-orden-compra.component';

const routes: Routes = [
  {
    path: '',
    component: ListarOrdenCompraComponent
  },
  {
    path: 'registrar',
    component: RegistrarOrdenCompraComponent
  },
  {
    path: 'actualizar',
    component: ActualizarOrdenCompraComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdencompraRoutingModule { }
