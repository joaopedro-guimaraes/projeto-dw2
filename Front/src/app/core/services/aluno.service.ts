import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ServiceEndpoints, serviceEndpoints } from '../utils';
import { Observable } from 'rxjs';

@Injectable()
export class AlunoService {

  constructor( private readonly httpClient: HttpClient ) { }

  cadastrar(cadastro: any) {
    return this.httpClient.post(serviceEndpoints(ServiceEndpoints.Aluno), cadastro) as Observable<any>;
  }

  getAluno(id: any): Observable<any> {
    return this.httpClient.get(serviceEndpoints(ServiceEndpoints.GetAluno, id)) as Observable<any>;
  }

  curriculo(curriculo: any) {
    return this.httpClient.post(serviceEndpoints(ServiceEndpoints.Curriculo), curriculo) as Observable<any>;
  }
}
