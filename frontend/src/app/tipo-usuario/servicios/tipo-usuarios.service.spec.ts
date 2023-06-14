import { TestBed } from '@angular/core/testing';
import { CommonModule } from '@angular/common';

import { TipoUsuarioService } from './tipo-usuarios.service';

describe('TipoUsuarioService', () => {
  let service: TipoUsuarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoUsuarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
