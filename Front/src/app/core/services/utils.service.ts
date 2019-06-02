import { EstadosCidades } from './../models/utils.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { dataEndpoints, DataEndpoints } from '../utils';


@Injectable()
export class UtilsService {

  constructor( private readonly httpClient: HttpClient ) { }

  getCidadesEstados(): Observable<EstadosCidades> {
    console.log(dataEndpoints);
    return this.httpClient.get(dataEndpoints(DataEndpoints.EstadosCidades)) as Observable<EstadosCidades>;
  }
}
