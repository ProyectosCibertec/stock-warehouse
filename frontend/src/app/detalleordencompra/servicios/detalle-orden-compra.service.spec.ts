import { TestBed } from '@angular/core/testing';

import { DetalleOrdenCompraService } from './detalle-orden-compra.service';

describe('DetalleOrdenCompraService', () => {
  let service: DetalleOrdenCompraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetalleOrdenCompraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
