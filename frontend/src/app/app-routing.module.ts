import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';

const routes: Routes = [
  {path:'proveedores', component:ListarProveedorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }