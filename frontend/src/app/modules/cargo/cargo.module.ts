import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CargoRoutingModule } from './cargo-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';
import { ListarComponent } from './page/listar/listar.component';
import { ActualizarComponent } from './page/actualizar/actualizar.component';
import { RegistrarComponent } from './page/registrar/registrar.component';


@NgModule({
  declarations: [
    ListarComponent,
    ActualizarComponent,
    RegistrarComponent
  ],
  imports: [
    CommonModule,
    CargoRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class CargoModule { }
