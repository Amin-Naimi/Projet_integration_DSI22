import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableprofReclamationRefuseeComponent } from './tableprof-reclamation-refusee.component';

describe('TableprofReclamationRefuseeComponent', () => {
  let component: TableprofReclamationRefuseeComponent;
  let fixture: ComponentFixture<TableprofReclamationRefuseeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableprofReclamationRefuseeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableprofReclamationRefuseeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
