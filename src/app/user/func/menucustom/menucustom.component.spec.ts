import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenucustomComponent } from './menucustom.component';

describe('MenucustomComponent', () => {
  let component: MenucustomComponent;
  let fixture: ComponentFixture<MenucustomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenucustomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenucustomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
