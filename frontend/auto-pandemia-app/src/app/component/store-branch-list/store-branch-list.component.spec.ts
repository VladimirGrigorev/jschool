import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreBranchListComponent } from './store-branch-list.component';

describe('StoreBranchListComponent', () => {
  let component: StoreBranchListComponent;
  let fixture: ComponentFixture<StoreBranchListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoreBranchListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreBranchListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
