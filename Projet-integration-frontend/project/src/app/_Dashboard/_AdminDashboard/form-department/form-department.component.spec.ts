import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDepartmentComponent } from './form-department.component';

describe('FormDepartmentComponent', () => {
  let component: FormDepartmentComponent;
  let fixture: ComponentFixture<FormDepartmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormDepartmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormDepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
