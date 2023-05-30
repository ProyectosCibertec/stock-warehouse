import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CabecerainventarioComponent } from './listar-cabecerainventario.component';

describe('CabecerainventarioComponent', () => {
  let component: CabecerainventarioComponent;
  let fixture: ComponentFixture<CabecerainventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CabecerainventarioComponent]
    });
    fixture = TestBed.createComponent(CabecerainventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
