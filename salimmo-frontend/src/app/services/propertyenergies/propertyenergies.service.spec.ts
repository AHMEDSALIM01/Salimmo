import { TestBed } from '@angular/core/testing';

import { PropertyenergiesService } from './propertyenergies.service';

describe('PropertyenergiesService', () => {
  let service: PropertyenergiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertyenergiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
