import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DetalleordencompraRoutingModule } from './detalleordencompra-routing.module';
import { ListarComponent } from './listar/listar.component';
import { MaterialModule } from 'src/app/app.material.module';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListarComponent
  ],
  imports: [
    CommonModule,
    DetalleordencompraRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class DetalleordencompraModule { }
