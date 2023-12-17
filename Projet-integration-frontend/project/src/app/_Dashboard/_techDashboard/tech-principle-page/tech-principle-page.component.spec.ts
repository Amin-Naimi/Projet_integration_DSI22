import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechPrinciplePageComponent } from './tech-principle-page.component';

describe('TechPrinciplePageComponent', () => {
  let component: TechPrinciplePageComponent;
  let fixture: ComponentFixture<TechPrinciplePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechPrinciplePageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TechPrinciplePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
