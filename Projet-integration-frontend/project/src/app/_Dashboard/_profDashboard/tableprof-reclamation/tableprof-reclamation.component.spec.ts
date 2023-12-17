import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableprofReclamationComponent } from './tableprof-reclamation.component';

describe('TableprofReclamationComponent', () => {
  let component: TableprofReclamationComponent;
  let fixture: ComponentFixture<TableprofReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableprofReclamationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableprofReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
