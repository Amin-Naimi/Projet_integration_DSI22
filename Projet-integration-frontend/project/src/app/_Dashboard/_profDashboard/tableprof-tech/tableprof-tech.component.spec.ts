import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableprofTechComponent } from './tableprof-tech.component';

describe('TableprofTechComponent', () => {
  let component: TableprofTechComponent;
  let fixture: ComponentFixture<TableprofTechComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableprofTechComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableprofTechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
