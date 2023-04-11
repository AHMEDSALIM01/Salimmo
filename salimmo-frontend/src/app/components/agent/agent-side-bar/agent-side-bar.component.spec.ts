import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentSideBarComponent } from './agent-side-bar.component';

describe('AgentSideBarComponent', () => {
  let component: AgentSideBarComponent;
  let fixture: ComponentFixture<AgentSideBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentSideBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
