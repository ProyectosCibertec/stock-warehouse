import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { ListarOrdenCompraComponent } from './ordencompra/componentes/listar-orden-compra/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './ordencompra/componentes/registrar-orden-compra/registrar-orden-compra.component';
import { ActualizarOrdenCompraComponent } from './ordencompra/componentes/actualizar-orden-compra/actualizar-orden-compra.component';
import { ListarCabeceraInventarioComponent } from './cabecerainventario/componentes/listar-cabecera-inventario/listar-cabecera-inventario.component';
import { RegistrarCabeceraInventarioComponent } from './cabecerainventario/componentes/registrar-cabecera-inventario/registrar-cabecera-inventario.component';
import { ActualizarCabeceraInventarioComponent } from './cabecerainventario/componentes/actualizar-cabecera-inventario/actualizar-cabecera-inventario.component';
import { ActualizarEmpleadoComponent } from './empleado/componentes/actualizar-empleado/actualizar-empleado.component';
import { ListarEmpleadoComponent } from './empleado/componentes/listar-empleado/listar-empleado.component';
import { RegistrarEmpleadoComponent } from './empleado/componentes/registrar-empleado/registrar-empleado.component';
const routes: Routes = [
  { path:'proveedores', component:ListarProveedorComponent},
  { path:'registrarProveedor',  component: RegistrarProveedorComponent},
  { path:'actualizarProveedor',  component: ActualizarProveedorComponent},
  { path: 'ordenesCompra', component: ListarOrdenCompraComponent },
  { path: 'nuevaOrdenCompra', component: RegistrarOrdenCompraComponent},
  { path: 'editarOrdenCompra', component: ActualizarOrdenCompraComponent},
  { path: 'cabecerasInventario', component: ListarCabeceraInventarioComponent},
  { path: 'nuevaCabeceraInventario', component: RegistrarCabeceraInventarioComponent},
  { path: 'editarCabeceraInventario', component: ActualizarCabeceraInventarioComponent},
  { path: 'empleados', component: ListarEmpleadoComponent },
  { path: 'registrarEmpleado', component: RegistrarEmpleadoComponent},
  { path: 'actualizarEmpleado', component: ActualizarEmpleadoComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
