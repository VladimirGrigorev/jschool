import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchasedSparePartsComponent } from './purchased-spare-parts.component';

describe('PurchasedSparePartsComponent', () => {
  let component: PurchasedSparePartsComponent;
  let fixture: ComponentFixture<PurchasedSparePartsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PurchasedSparePartsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchasedSparePartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
