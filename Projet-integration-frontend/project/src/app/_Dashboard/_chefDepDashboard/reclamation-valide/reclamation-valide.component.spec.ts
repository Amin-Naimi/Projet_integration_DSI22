import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReclamationValideComponent } from './reclamation-valide.component';

describe('ReclamationValideComponent', () => {
  let component: ReclamationValideComponent;
  let fixture: ComponentFixture<ReclamationValideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReclamationValideComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReclamationValideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
