import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfPrincipalPageComponent } from './prof-principal-page.component';

describe('ProfPrincipalPageComponent', () => {
  let component: ProfPrincipalPageComponent;
  let fixture: ComponentFixture<ProfPrincipalPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfPrincipalPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfPrincipalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
