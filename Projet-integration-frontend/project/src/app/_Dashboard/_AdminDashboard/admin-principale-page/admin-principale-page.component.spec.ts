import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPrincipalePageComponent } from './admin-principale-page.component';

describe('AdminPrincipalePageComponent', () => {
  let component: AdminPrincipalePageComponent;
  let fixture: ComponentFixture<AdminPrincipalePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminPrincipalePageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminPrincipalePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
