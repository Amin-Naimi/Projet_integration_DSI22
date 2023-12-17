import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabletechChefComponent } from './tabletech-chef.component';

describe('TabletechChefComponent', () => {
  let component: TabletechChefComponent;
  let fixture: ComponentFixture<TabletechChefComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TabletechChefComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabletechChefComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
