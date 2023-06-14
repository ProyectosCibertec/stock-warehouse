import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarTipoUsuarioComponent } from './registrar-tipo-usuario.component';

describe('RegistrarTipoUsuarioComponent', () => {
  let component: RegistrarTipoUsuarioComponent;
  let fixture: ComponentFixture<RegistrarTipoUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrarTipoUsuarioComponent]
    });
    fixture = TestBed.createComponent(RegistrarTipoUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
