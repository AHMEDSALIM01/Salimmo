import { TestBed } from '@angular/core/testing';

import { InnerpropertyService } from './innerproperty.service';

describe('InnerpropertyService', () => {
  let service: InnerpropertyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InnerpropertyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
