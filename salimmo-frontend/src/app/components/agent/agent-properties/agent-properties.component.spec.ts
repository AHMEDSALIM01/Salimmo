import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentPropertiesComponent } from './agent-properties.component';

describe('AgentPropertiesComponent', () => {
  let component: AgentPropertiesComponent;
  let fixture: ComponentFixture<AgentPropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentPropertiesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
