import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EliminarTipoUsuarioComponent } from './eliminar-tipo-usuario.component';

describe('EliminarTipoUsuarioComponent', () => {
  let component: EliminarTipoUsuarioComponent;
  let fixture: ComponentFixture<EliminarTipoUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EliminarTipoUsuarioComponent]
    });
    fixture = TestBed.createComponent(EliminarTipoUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
