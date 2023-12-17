import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabletechTechComponent } from './tabletech-tech.component';

describe('TabletechTechComponent', () => {
  let component: TabletechTechComponent;
  let fixture: ComponentFixture<TabletechTechComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TabletechTechComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabletechTechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
