import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChefPrincipalPageComponent } from './chef-principal-page.component';

describe('ChefPrincipalPageComponent', () => {
  let component: ChefPrincipalPageComponent;
  let fixture: ComponentFixture<ChefPrincipalPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChefPrincipalPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChefPrincipalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
