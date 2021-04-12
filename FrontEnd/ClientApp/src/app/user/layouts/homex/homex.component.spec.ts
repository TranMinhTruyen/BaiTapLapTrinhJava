import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomexComponent } from './homex.component';

describe('HomexComponent', () => {
  let component: HomexComponent;
  let fixture: ComponentFixture<HomexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
