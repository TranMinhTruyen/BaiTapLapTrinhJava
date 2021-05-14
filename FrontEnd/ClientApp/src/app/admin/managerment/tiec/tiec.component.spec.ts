import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiecComponent } from './tiec.component';

describe('TiecComponent', () => {
  let component: TiecComponent;
  let fixture: ComponentFixture<TiecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TiecComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TiecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
