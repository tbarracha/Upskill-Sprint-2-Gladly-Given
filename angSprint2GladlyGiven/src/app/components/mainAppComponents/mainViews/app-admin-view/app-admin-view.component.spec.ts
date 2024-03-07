import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppAdminViewComponent } from './app-admin-view.component';

describe('AppAdminViewComponent', () => {
  let component: AppAdminViewComponent;
  let fixture: ComponentFixture<AppAdminViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppAdminViewComponent]
    });
    fixture = TestBed.createComponent(AppAdminViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
