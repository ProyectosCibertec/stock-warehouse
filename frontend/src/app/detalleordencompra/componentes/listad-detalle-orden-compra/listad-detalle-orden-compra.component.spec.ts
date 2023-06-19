import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadDetalleOrdenCompraComponent } from './listad-detalle-orden-compra.component';

describe('ListadDetalleOrdenCompraComponent', () => {
  let component: ListadDetalleOrdenCompraComponent;
  let fixture: ComponentFixture<ListadDetalleOrdenCompraComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListadDetalleOrdenCompraComponent]
    });
    fixture = TestBed.createComponent(ListadDetalleOrdenCompraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
