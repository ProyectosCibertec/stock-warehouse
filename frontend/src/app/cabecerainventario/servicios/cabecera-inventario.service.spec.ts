import { TestBed } from '@angular/core/testing';

import { CabeceraInventarioService } from './cabecera-inventario.service';

describe('OrdenCompraService', () => {
  let service: CabeceraInventarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CabeceraInventarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
