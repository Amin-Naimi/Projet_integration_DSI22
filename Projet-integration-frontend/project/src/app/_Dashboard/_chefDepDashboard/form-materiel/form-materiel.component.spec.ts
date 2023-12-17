import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormMaterielComponent } from './form-materiel.component';

describe('FormMaterielComponent', () => {
  let component: FormMaterielComponent;
  let fixture: ComponentFixture<FormMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormMaterielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
