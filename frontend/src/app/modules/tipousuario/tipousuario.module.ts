import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TipousuarioRoutingModule } from './tipousuario-routing.module';
import { ListarComponent } from './page/listar/listar.component';
import { RegistrarComponent } from './page/registrar/registrar.component';
import { ActualizarComponent } from './page/actualizar/actualizar.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';


@NgModule({
  declarations: [
    ListarComponent,
    RegistrarComponent,
    ActualizarComponent
  ],
  imports: [
    CommonModule,
    TipousuarioRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class TipousuarioModule { }
