import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleinventarioComponent } from './detalleinventario.component';

describe('DetalleinventarioComponent', () => {
  let component: DetalleinventarioComponent;
  let fixture: ComponentFixture<DetalleinventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalleinventarioComponent]
    });
    fixture = TestBed.createComponent(DetalleinventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
