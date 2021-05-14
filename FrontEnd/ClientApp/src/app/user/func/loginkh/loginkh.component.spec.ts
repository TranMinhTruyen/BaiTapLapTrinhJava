import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginkhComponent } from './loginkh.component';

describe('LoginkhComponent', () => {
  let component: LoginkhComponent;
  let fixture: ComponentFixture<LoginkhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginkhComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginkhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
