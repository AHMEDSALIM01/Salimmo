import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentNavbarComponent } from './agent-navbar.component';

describe('NavbarComponent', () => {
  let component: AgentNavbarComponent;
  let fixture: ComponentFixture<AgentNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentNavbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
