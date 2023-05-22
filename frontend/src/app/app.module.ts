import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { EliminarProveedorComponent } from './proveedor/componentes/eliminar-proveedor/eliminar-proveedor.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarProveedorComponent,
    RegistrarProveedorComponent,
    ActualizarProveedorComponent,
    EliminarProveedorComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
