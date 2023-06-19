import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarProveedorComponent } from './page/listar/listar-proveedor.component';
import { RegistrarProveedorComponent } from './page/registrar/registrar-proveedor.component';
import { ActualizarProveedorComponent } from './page/actualizar/actualizar-proveedor.component';

const routes: Routes = [
  {
    path: '',
    component: ListarProveedorComponent
  },
  {
    path: 'registrar',
    component: RegistrarProveedorComponent
  },
  {
    path: 'actualizar/:id',
    component: ActualizarProveedorComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProveedorRoutingModule { }
