import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabletechMaterielComponent } from './tabletech-materiel.component';

describe('TabletechMaterielComponent', () => {
  let component: TabletechMaterielComponent;
  let fixture: ComponentFixture<TabletechMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TabletechMaterielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabletechMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
