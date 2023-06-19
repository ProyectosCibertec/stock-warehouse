import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModule } from './usuario-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';
import { ActualizarUsuarioComponent } from './page/actualizar/actualizar-usuario.component';
import { RegistrarUsuarioComponent } from './page/registrar/registrar-usuario.component';
import { ListarUsuarioComponent } from './page/listar/listar-usuario.component';


@NgModule({
  declarations: [
    ActualizarUsuarioComponent,
    RegistrarUsuarioComponent,
    ListarUsuarioComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class UsuarioModule { }
