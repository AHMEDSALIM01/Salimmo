import { TestBed } from '@angular/core/testing';

import { PropertysurfaceService } from './propertysurface.service';

describe('PropertysurfaceService', () => {
  let service: PropertysurfaceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertysurfaceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
