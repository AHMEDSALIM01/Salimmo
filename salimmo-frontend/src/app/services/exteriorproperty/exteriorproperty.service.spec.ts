import { TestBed } from '@angular/core/testing';

import { ExteriorpropertyService } from './exteriorproperty.service';

describe('ExteriorpropertyService', () => {
  let service: ExteriorpropertyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExteriorpropertyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
