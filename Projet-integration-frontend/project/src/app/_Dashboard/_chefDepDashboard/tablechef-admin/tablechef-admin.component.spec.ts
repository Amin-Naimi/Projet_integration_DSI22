import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablechefAdminComponent } from './tablechef-admin.component';

describe('TablechefAdminComponent', () => {
  let component: TablechefAdminComponent;
  let fixture: ComponentFixture<TablechefAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablechefAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablechefAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
