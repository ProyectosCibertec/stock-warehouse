import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdencompraRoutingModule } from './ordencompra-routing.module';
import { ActualizarOrdenCompraComponent } from './page/actualizar/actualizar-orden-compra.component';
import { RegistrarOrdenCompraComponent } from './page/registrar/registrar-orden-compra.component';
import { ListarOrdenCompraComponent } from './page/listar/listar-orden-compra.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';
import { ProductoModalComponent } from './page/producto-modal/producto-modal.component';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    ActualizarOrdenCompraComponent,
    RegistrarOrdenCompraComponent,
    ListarOrdenCompraComponent,
    ProductoModalComponent
  ],
  imports: [
    CommonModule,
    OrdencompraRoutingModule,
    FormsModule,
    MaterialModule,
    ToastrModule.forRoot(),
  ]
})
export class OrdencompraModule { }
