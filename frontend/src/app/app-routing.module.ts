import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';


const routes: Routes = [
  {path:'proveedores', component:ListarProveedorComponent},
  { path:'registrarProveedor',  component: RegistrarProveedorComponent},
  { path:'actualizarProveedor',  component: ActualizarProveedorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }