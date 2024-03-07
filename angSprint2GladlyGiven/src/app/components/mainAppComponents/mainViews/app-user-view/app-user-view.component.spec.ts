import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppUserViewComponent } from './app-user-view.component';

describe('AppUserViewComponent', () => {
  let component: AppUserViewComponent;
  let fixture: ComponentFixture<AppUserViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppUserViewComponent]
    });
    fixture = TestBed.createComponent(AppUserViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
