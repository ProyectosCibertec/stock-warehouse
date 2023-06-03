import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarCabeceraInventarioComponent } from './actualizar-cabecera-inventario.component';

describe('ActualizarCabeceraInventarioComponent', () => {
  let component: ActualizarCabeceraInventarioComponent;
  let fixture: ComponentFixture<ActualizarCabeceraInventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActualizarCabeceraInventarioComponent]
    });
    fixture = TestBed.createComponent(ActualizarCabeceraInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
