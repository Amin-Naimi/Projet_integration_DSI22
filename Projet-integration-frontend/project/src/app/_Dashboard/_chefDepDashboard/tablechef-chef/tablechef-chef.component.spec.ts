import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablechefChefComponent } from './tablechef-chef.component';

describe('TablechefChefComponent', () => {
  let component: TablechefChefComponent;
  let fixture: ComponentFixture<TablechefChefComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablechefChefComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablechefChefComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
