import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { UserModel } from './../models/user.model';
import { ServiceEndpoints, serviceEndpoints } from '../utils';

@Injectable()
export class UserService {

  constructor( private readonly httpClient: HttpClient ) { }

  cadastrar(user: UserModel) {
    return this.httpClient.post(serviceEndpoints(ServiceEndpoints.Cadastrar), user) as Observable<any>;
  }

}
