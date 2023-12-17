import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormprofReclamationComponent } from './formprof-reclamation.component';

describe('FormprofReclamationComponent', () => {
  let component: FormprofReclamationComponent;
  let fixture: ComponentFixture<FormprofReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormprofReclamationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormprofReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
