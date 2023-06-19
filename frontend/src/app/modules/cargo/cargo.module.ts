import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CargoRoutingModule } from './cargo-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/app.material.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CargoRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class CargoModule { }
