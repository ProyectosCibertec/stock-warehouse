import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActualizarProveedorComponent } from './proveedor/componentes/actualizar-proveedor/actualizar-proveedor.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { RegistrarProveedorComponent } from './proveedor/componentes/registrar-proveedor/registrar-proveedor.component';
import { ListarOrdenCompraComponent } from './ordencompra/componentes/listar-orden-compra/listar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './ordencompra/componentes/registrar-orden-compra/registrar-orden-compra.component';
import { ActualizarOrdenCompraComponent } from './ordencompra/componentes/actualizar-orden-compra/actualizar-orden-compra.component';
import {MaterialModule} from './app.material.module';
import { ActualizarCabeceraInventarioComponent } from './cabecerainventario/componentes/actualizar-cabecera-inventario/actualizar-cabecera-inventario.component';
import { RegistrarCabeceraInventarioComponent } from './cabecerainventario/componentes/registrar-cabecera-inventario/registrar-cabecera-inventario.component';
import { ListarCabeceraInventarioComponent } from './cabecerainventario/componentes/listar-cabecera-inventario/listar-cabecera-inventario.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarProveedorComponent,
    ListarOrdenCompraComponent,
    RegistrarOrdenCompraComponent,
    ActualizarOrdenCompraComponent,
    ActualizarCabeceraInventarioComponent,
    RegistrarCabeceraInventarioComponent,
    ListarCabeceraInventarioComponent,
    RegistrarProveedorComponent,
    ActualizarProveedorComponent
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
