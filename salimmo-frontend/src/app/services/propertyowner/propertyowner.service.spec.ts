import { TestBed } from '@angular/core/testing';

import { PropertyownerService } from './propertyowner.service';

describe('PropertyownerService', () => {
  let service: PropertyownerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertyownerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
