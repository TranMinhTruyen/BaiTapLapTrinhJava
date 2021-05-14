import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DattiecquanlyComponent } from './dattiecquanly.component';

describe('DattiecquanlyComponent', () => {
  let component: DattiecquanlyComponent;
  let fixture: ComponentFixture<DattiecquanlyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DattiecquanlyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DattiecquanlyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
