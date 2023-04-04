import { TestBed } from '@angular/core/testing';

import { PropertylocationService } from './propertylocation.service';

describe('PropertylocationService', () => {
  let service: PropertylocationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertylocationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
