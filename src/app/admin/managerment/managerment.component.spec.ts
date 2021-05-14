import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagermentComponent } from './managerment.component';

describe('ManagermentComponent', () => {
  let component: ManagermentComponent;
  let fixture: ComponentFixture<ManagermentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagermentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagermentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
