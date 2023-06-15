import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './app.material.module';
import { ListarEmpleadoComponent } from './modules/empleado/page/listar/listar-empleado.component';
import { RegistrarEmpleadoComponent } from './modules/empleado/page/registrar/registrar-empleado.component';
import { ActualizarOrdenCompraComponent } from './modules/ordencompra/page/actualizar/actualizar-orden-compra.component';
import { ListarOrdenCompraComponent } from './modules/ordencompra/page/listar/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './modules/ordencompra/page/registrar/registrar-orden-compra.component';
import { ActualizarProveedorComponent } from './modules/proveedor/page/actualizar/actualizar-proveedor.component';
import { ListarProveedorComponent } from './modules/proveedor/page/listar/listar-proveedor.component';
import { RegistrarProveedorComponent } from './modules/proveedor/page/registrar/registrar-proveedor.component';
import { AuthLayoutComponent } from './layout/auth-layout/auth-layout.component';
import { ContentLayoutComponent } from './layout/content-layout/content-layout.component';
import { ActualizarEmpleadoComponent } from "./modules/empleado/page/actualizar/actualizar-empleado.component";
import { LoginComponent } from "./modules/auth/page/login/login.component";
import { CoreModule } from "./core/core.module";

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
    ActualizarProveedorComponent,
    AuthLayoutComponent,
    ContentLayoutComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule,
    CoreModule
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule {}
