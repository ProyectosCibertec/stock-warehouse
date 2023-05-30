import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { CabecerainventarioComponent } from './cabecerainventario/cabecerainventario.component';
import { DetalleinventarioComponent } from './detalleinventario/detalleinventario.component';



@NgModule({
  declarations: [
    AppComponent,
    ListarProveedorComponent,
    CabecerainventarioComponent,
    DetalleinventarioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
