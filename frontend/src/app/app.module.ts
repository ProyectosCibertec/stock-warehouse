import { HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './app.material.module';
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


@NgModule({
  declarations: [
    AppComponent,
    ListarProveedorComponent,
    ListarOrdenCompraComponent,
    RegistrarOrdenCompraComponent,
    ActualizarOrdenCompraComponent,
    RegistrarProveedorComponent,
    ActualizarProveedorComponent,
    ListarEmpleadoComponent,
    RegistrarEmpleadoComponent,
    ActualizarEmpleadoComponent,
    ListarProductoComponent,
    RegistrarProductoComponent,
    ActualizarProductoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
