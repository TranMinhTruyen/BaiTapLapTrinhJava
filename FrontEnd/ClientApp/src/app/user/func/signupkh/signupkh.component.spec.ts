import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupkhComponent } from './signupkh.component';

describe('SignupkhComponent', () => {
  let component: SignupkhComponent;
  let fixture: ComponentFixture<SignupkhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupkhComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupkhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
