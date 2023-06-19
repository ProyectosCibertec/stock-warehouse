import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarUsuarioComponent } from './page/listar/listar-usuario.component';
import { RegistrarUsuarioComponent } from './page/registrar/registrar-usuario.component';
import { ActualizarUsuarioComponent } from './page/actualizar/actualizar-usuario.component';

const routes: Routes = [
  {
    path: '',
    component: ListarUsuarioComponent
  },
  {
    path: 'registrar',
    component: RegistrarUsuarioComponent
  },
  {
    path: 'actualizar',
    component: ActualizarUsuarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
