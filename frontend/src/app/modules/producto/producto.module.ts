import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductoRoutingModule } from './producto-routing.module';
import { ListarComponent } from './page/listar/listar.component';
import { ActualizarComponent } from './page/actualizar/actualizar.component';
import { RegistrarComponent } from './page/registrar/registrar.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';


@NgModule({
  declarations: [
    ListarComponent,
    ActualizarComponent,
    RegistrarComponent
  ],
  imports: [
    CommonModule,
    ProductoRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class ProductoModule { }
