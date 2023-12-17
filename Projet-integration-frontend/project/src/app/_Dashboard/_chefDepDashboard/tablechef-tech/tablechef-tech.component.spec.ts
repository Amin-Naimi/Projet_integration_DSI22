import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablechefTechComponent } from './tablechef-tech.component';

describe('TablechefTechComponent', () => {
  let component: TablechefTechComponent;
  let fixture: ComponentFixture<TablechefTechComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablechefTechComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablechefTechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
