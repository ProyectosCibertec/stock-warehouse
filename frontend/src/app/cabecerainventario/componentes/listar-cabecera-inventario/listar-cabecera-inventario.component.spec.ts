import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCabeceraInventarioComponent } from './listar-cabecera-inventario.component';

describe('ListarCabeceraInventarioComponent', () => {
  let component: ListarCabeceraInventarioComponent;
  let fixture: ComponentFixture<ListarCabeceraInventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCabeceraInventarioComponent]
    });
    fixture = TestBed.createComponent(ListarCabeceraInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
