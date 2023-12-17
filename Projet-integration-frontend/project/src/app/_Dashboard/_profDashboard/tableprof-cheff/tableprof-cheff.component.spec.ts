import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableprofCheffComponent } from './tableprof-cheff.component';

describe('TableprofCheffComponent', () => {
  let component: TableprofCheffComponent;
  let fixture: ComponentFixture<TableprofCheffComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableprofCheffComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableprofCheffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
