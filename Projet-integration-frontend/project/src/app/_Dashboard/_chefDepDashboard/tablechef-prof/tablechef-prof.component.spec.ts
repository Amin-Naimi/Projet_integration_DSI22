import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablechefProfComponent } from './tablechef-prof.component';

describe('TablechefProfComponent', () => {
  let component: TablechefProfComponent;
  let fixture: ComponentFixture<TablechefProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablechefProfComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablechefProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
