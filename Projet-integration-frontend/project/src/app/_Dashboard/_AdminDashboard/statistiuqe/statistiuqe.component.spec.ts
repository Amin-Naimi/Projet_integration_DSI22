import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatistiuqeComponent } from './statistiuqe.component';

describe('StatistiuqeComponent', () => {
  let component: StatistiuqeComponent;
  let fixture: ComponentFixture<StatistiuqeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatistiuqeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatistiuqeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
