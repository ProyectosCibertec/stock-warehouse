import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { ListarOrdenCompraComponent } from './ordencompra/componentes/listar-orden-compra/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './ordencompra/componentes/registrar-orden-compra/registrar-orden-compra.component';
import { ActualizarOrdenCompraComponent } from './ordencompra/componentes/actualizar-orden-compra/actualizar-orden-compra.component';

const routes: Routes = [
  { path:'proveedores', component:ListarProveedorComponent},
  { path:'registrarProveedor',  component: RegistrarProveedorComponent},
  { path:'actualizarProveedor',  component: ActualizarProveedorComponent},
  { path: 'ordenesCompra', component: ListarOrdenCompraComponent },
  { path: 'nuevaOrdenCompra', component: RegistrarOrdenCompraComponent},
  { path: 'editarOrdenCompra', component: ActualizarOrdenCompraComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }