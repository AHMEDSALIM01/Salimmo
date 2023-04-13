import { TestBed } from '@angular/core/testing';

import { KeycloackHttpInterceptorServiceService } from './keycloack-http-interceptor-service.service';

describe('KeycloackHttpInterceptorServiceService', () => {
  let service: KeycloackHttpInterceptorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KeycloackHttpInterceptorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
