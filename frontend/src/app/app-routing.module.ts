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
import { ActualizarProductoComponent } from './producto/componentes/actualizar-producto/actualizar-producto.component';
import { ListarProductoComponent } from './producto/componentes/listar-producto/listar-producto.component';
import { RegistrarProductoComponent } from './producto/componentes/registrar-producto/registrar-producto.component';

const routes: Routes = [
  { path:'proveedores', component:ListarProveedorComponent},
  { path:'registrarProveedor',  component: RegistrarProveedorComponent},
  { path:'actualizarProveedor',  component: ActualizarProveedorComponent},
  { path: 'ordenesCompra', component: ListarOrdenCompraComponent },
  { path: 'nuevaOrdenCompra', component: RegistrarOrdenCompraComponent},
  { path: 'editarOrdenCompra', component: ActualizarOrdenCompraComponent},
  { path: 'empleados', component: ListarEmpleadoComponent },
  { path: 'registrarEmpleado', component: RegistrarEmpleadoComponent},
  { path: 'actualizarEmpleado', component: ActualizarEmpleadoComponent},
  { path:'productos', component:ListarProductoComponent},
  { path:'registrarProducto',  component: RegistrarProductoComponent},
  { path:'actualizarProducto',  component: ActualizarProductoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }