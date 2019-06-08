import { LoginModel } from './../models/login.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ServiceEndpoints, serviceEndpoints } from '../utils';
import { Observable } from 'rxjs';

@Injectable()
export class LoginService {

  constructor( private readonly httpClient: HttpClient ) { }

  login(login: LoginModel) {
    return this.httpClient.post(serviceEndpoints(ServiceEndpoints.Login), login) as Observable<any>;
  }

}
