import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DattiecComponent } from './dattiec.component';

describe('DattiecComponent', () => {
  let component: DattiecComponent;
  let fixture: ComponentFixture<DattiecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DattiecComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DattiecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
