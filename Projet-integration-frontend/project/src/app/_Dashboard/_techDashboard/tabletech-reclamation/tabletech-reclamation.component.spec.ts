import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabletechReclamationComponent } from './tabletech-reclamation.component';

describe('TabletechReclamationComponent', () => {
  let component: TabletechReclamationComponent;
  let fixture: ComponentFixture<TabletechReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TabletechReclamationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabletechReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
