import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarTipoUsuarioComponent } from './actualizar-tipo-usuario.component';

describe('ActualizarTipoUsuarioComponent', () => {
  let component: ActualizarTipoUsuarioComponent;
  let fixture: ComponentFixture<ActualizarTipoUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActualizarTipoUsuarioComponent]
    });
    fixture = TestBed.createComponent(ActualizarTipoUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
