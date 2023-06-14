import { HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './app.material.module';
import { ListarTipoUsuarioComponent } from "./tipo-usuario/componentes/listar-tipo-usuario/listar-tipo-usuario.component";
import { ActualizarEmpleadoComponent } from './empleado/componentes/actualizar-empleado/actualizar-empleado.component';
import { ListarEmpleadoComponent } from './empleado/componentes/listar-empleado/listar-empleado.component';
import { RegistrarEmpleadoComponent } from './empleado/componentes/registrar-empleado/registrar-empleado.component';
import { ActualizarOrdenCompraComponent } from './ordencompra/componentes/actualizar-orden-compra/actualizar-orden-compra.component';
import { ListarOrdenCompraComponent } from './ordencompra/componentes/listar-orden-compra/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './ordencompra/componentes/registrar-orden-compra/registrar-orden-compra.component';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { RegistrarTipoUsuarioComponent } from "./tipo-usuario/componentes/registrar-tipo-usuario/registrar-tipo-usuario.component";
import { ActualizarTipoUsuarioComponent } from "./tipo-usuario/componentes/actualizar-tipo-usuario/actualizar-tipo-usuario.component";
import { ListarUsuarioComponent } from "./usuario/componentes/listar-usuario/listar-usuario.component";
import { RegistrarUsuarioComponent } from "./usuario/componentes/registrar-usuario/registrar-usuario.component";
import { ActualizarUsuarioComponent } from "./usuario/componentes/actualizar-usuario/actualizar-usuario.component";

@NgModule({
  declarations: [
    AppComponent,
    ListarProveedorComponent,
    ListarTipoUsuarioComponent,
    ListarUsuarioComponent,
    ListarOrdenCompraComponent,
    RegistrarOrdenCompraComponent,
    RegistrarTipoUsuarioComponent,
    RegistrarUsuarioComponent,
    ActualizarUsuarioComponent,
    ActualizarOrdenCompraComponent,
    ActualizarTipoUsuarioComponent,
    RegistrarProveedorComponent,
    ActualizarProveedorComponent,
    ListarEmpleadoComponent,
    RegistrarEmpleadoComponent,
    ActualizarEmpleadoComponent
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
