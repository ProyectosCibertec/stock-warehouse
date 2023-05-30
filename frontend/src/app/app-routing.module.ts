import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarProveedorComponent } from './proveedor/componentes/listar-proveedor/listar-proveedor.component';
import { CabecerainventarioComponent } from './cabecerainventario/cabecerainventario.component';
import { DetalleinventarioComponent } from './detalleinventario/detalleinventario.component';


const routes: Routes = [
  {path:'proveedor', component:ListarProveedorComponent},
  { path: 'cabecerainventario', component:CabecerainventarioComponent},
  { path: 'detalleinventario', component:DetalleinventarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }