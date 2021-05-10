import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThucanComponent } from './thucan.component';

describe('ThucanComponent', () => {
  let component: ThucanComponent;
  let fixture: ComponentFixture<ThucanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThucanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThucanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
