import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentListPropertiesComponent } from './agent-list-properties.component';

describe('AgentListPropertiesComponent', () => {
  let component: AgentListPropertiesComponent;
  let fixture: ComponentFixture<AgentListPropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentListPropertiesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentListPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
