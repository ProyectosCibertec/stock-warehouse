import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CommonModule } from '@angular/common';
import { ListarTipoUsuarioComponent } from './listar-tipo-usuario.component';

describe('ListarTipoUsuarioComponent', () => {
  let component: ListarTipoUsuarioComponent;
  let fixture: ComponentFixture<ListarTipoUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarTipoUsuarioComponent]
    });
    fixture = TestBed.createComponent(ListarTipoUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
