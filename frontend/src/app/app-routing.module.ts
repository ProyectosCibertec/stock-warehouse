import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarEmpleadoComponent } from './empleado/componentes/actualizar-empleado/actualizar-empleado.component';
import { ListarEmpleadoComponent } from './empleado/componentes/listar-empleado/listar-empleado.component';
import { RegistrarEmpleadoComponent } from './empleado/componentes/registrar-empleado/registrar-empleado.component';
import { ActualizarOrdenCompraComponent } from './ordencompra/componentes/actualizar-orden-compra/actualizar-orden-compra.component';
import { ListarOrdenCompraComponent } from './ordencompra/componentes/listar-orden-compra/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './ordencompra/componentes/registrar-orden-compra/registrar-orden-compra.component';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { ListarTipoUsuarioComponent } from './tipo-usuario/componentes/listar-tipo-usuario//listar-tipo-usuario.component';
import { RegistrarTipoUsuarioComponent } from './tipo-usuario/componentes/registrar-tipo-usuario/registrar-tipo-usuario.component';
import { ActualizarTipoUsuarioComponent } from './tipo-usuario/componentes/actualizar-tipo-usuario/actualizar-tipo-usuario.component';
import { ListarUsuarioComponent } from './usuario/componentes/listar-usuario/listar-usuario.component';
import { RegistrarUsuarioComponent } from './usuario/componentes/registrar-usuario/registrar-usuario.component';
import { ActualizarUsuarioComponent } from './usuario/componentes/actualizar-usuario/actualizar-usuario.component';


const routes: Routes = [
  { path: 'nuevoUsuario', component: RegistrarUsuarioComponent},
  { path: 'editarUsuario', component: ActualizarUsuarioComponent},
  { path: 'nuevaTipoUsuario', component: RegistrarTipoUsuarioComponent},
  { path:'tiposUsuario', component:ListarTipoUsuarioComponent},
  { path:'usuarios', component:ListarUsuarioComponent},
  { path:'proveedores', component:ListarProveedorComponent},
  { path:'registrarProveedor',  component: RegistrarProveedorComponent},
  { path:'actualizarProveedor',  component: ActualizarProveedorComponent},
  { path: 'ordenesCompra', component: ListarOrdenCompraComponent },
  { path: 'nuevaOrdenCompra', component: RegistrarOrdenCompraComponent},
  { path: 'editarOrdenCompra', component: ActualizarOrdenCompraComponent},
  { path: 'empleados', component: ListarEmpleadoComponent },
  { path: 'registrarEmpleado', component: RegistrarEmpleadoComponent},
  { path: 'actualizarEmpleado', component: ActualizarEmpleadoComponent},
  { path: 'editarTipoUsuario', component: ActualizarTipoUsuarioComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }