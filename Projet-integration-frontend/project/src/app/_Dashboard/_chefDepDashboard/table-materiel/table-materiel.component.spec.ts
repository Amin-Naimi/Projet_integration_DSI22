import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableMaterielComponent } from './table-materiel.component';

describe('TableMaterielComponent', () => {
  let component: TableMaterielComponent;
  let fixture: ComponentFixture<TableMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableMaterielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
