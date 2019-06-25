import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ServiceEndpoints, serviceEndpoints } from '../utils';
import { Observable } from 'rxjs';

@Injectable()
export class EstagioService {

  constructor( private readonly httpClient: HttpClient ) { }

  cadastrar(cadastro: any) {
    return this.httpClient.post(serviceEndpoints(ServiceEndpoints.Estagio), cadastro) as Observable<any>;
  }

}
