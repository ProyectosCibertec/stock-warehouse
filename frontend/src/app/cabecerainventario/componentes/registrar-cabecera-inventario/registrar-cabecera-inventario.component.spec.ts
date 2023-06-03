import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarCabeceraInventarioComponent } from './registrar-cabecera-inventario.component';

describe('RegistrarCabeceraInventarioComponent', () => {
  let component: RegistrarCabeceraInventarioComponent;
  let fixture: ComponentFixture<RegistrarCabeceraInventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrarCabeceraInventarioComponent]
    });
    fixture = TestBed.createComponent(RegistrarCabeceraInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
