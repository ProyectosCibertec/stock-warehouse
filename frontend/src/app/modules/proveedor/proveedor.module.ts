import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProveedorRoutingModule } from './proveedor-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';
import { RegistrarProveedorComponent } from './page/registrar/registrar-proveedor.component';
import { ListarProveedorComponent } from './page/listar/listar-proveedor.component';
import { ActualizarProveedorComponent } from './page/actualizar/actualizar-proveedor.component';


@NgModule({
  declarations: [
    RegistrarProveedorComponent,
    ListarProveedorComponent,
    ActualizarProveedorComponent
  ],
  imports: [
    CommonModule,
    ProveedorRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class ProveedorModule { }
