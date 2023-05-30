import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule}from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatNativeDateModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {NgIf} from '@angular/common';


@NgModule({
    imports: [
      BrowserAnimationsModule,
      MatSidenavModule,
      MatFormFieldModule, 
      MatSelectModule, 
      MatButtonModule,
      MatToolbarModule, 
      MatIconModule,
      MatCardModule,
      MatStepperModule,
      MatNativeDateModule,
      MatInputModule,
      MatDatepickerModule,
      NgIf,
    ],
    exports : [
      BrowserAnimationsModule,
      MatSidenavModule,
      MatFormFieldModule, 
      MatSelectModule, 
      MatButtonModule,
      MatToolbarModule, 
      MatIconModule,
      MatCardModule,
      MatStepperModule,
      MatNativeDateModule,
      MatInputModule,
      MatDatepickerModule,
      NgIf,
    ]
  })
export class MaterialModule{}