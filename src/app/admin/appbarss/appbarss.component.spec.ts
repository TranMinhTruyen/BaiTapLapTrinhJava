import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppbarssComponent } from './appbarss.component';

describe('AppbarssComponent', () => {
  let component: AppbarssComponent;
  let fixture: ComponentFixture<AppbarssComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppbarssComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppbarssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
