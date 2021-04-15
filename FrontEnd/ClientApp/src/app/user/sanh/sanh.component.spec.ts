import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SanhComponent } from './sanh.component';

describe('SanhComponent', () => {
  let component: SanhComponent;
  let fixture: ComponentFixture<SanhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SanhComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SanhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
