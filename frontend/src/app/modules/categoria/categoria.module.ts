import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriaRoutingModule } from './categoria-routing.module';
import { RegistrarComponent } from './page/registrar/registrar.component';
import { ActualizarComponent } from './page/actualizar/actualizar.component';
import { ListarComponent } from './page/listar/listar.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';


@NgModule({
  declarations: [
    RegistrarComponent,
    ActualizarComponent,
    ListarComponent
  ],
  imports: [
    CommonModule,
    CategoriaRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class CategoriaModule { }
