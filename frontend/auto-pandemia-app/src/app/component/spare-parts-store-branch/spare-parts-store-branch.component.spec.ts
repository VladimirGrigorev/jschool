import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SparePartsStoreBranchComponent } from './spare-parts-store-branch.component';

describe('SparePartsStoreBranchComponent', () => {
  let component: SparePartsStoreBranchComponent;
  let fixture: ComponentFixture<SparePartsStoreBranchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SparePartsStoreBranchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SparePartsStoreBranchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
