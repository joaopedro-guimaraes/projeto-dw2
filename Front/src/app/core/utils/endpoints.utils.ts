import { environment } from './../../../environments/environment';

export const enum DataEndpoints {
  EstadosCidades = 'estados-cidades.json',
}

export const enum ServiceEndpoints {
  Login = 'login',
}

/** Interpola os parâmetros 'params[i]' nos '{{i}}' do endpoint, caso existam */
export const endpointInterpolation = (baseUrl: string, endpoint: string, ...params: Array<string|number>) => {
  const interpolatedEndpoint = params.reduce<string>((old, curr, i) => old.split(`{{${i}}}`).join(curr.toString()), endpoint);
  return baseUrl + interpolatedEndpoint;
};

/** Retorna a URL completa de um "endpoint" de dados fixos */
export const dataEndpoints = (endpoint: DataEndpoints): string => {
  return endpointInterpolation('assets/data/', endpoint);
};

/** Retorna a URL completa de um endpoint do backend, com os parâmetros 'params[i]' interpolados */
export const serviceEndpoints = (endpoint: ServiceEndpoints, ...params: Array<string | number>): string => {
  return endpointInterpolation(environment.backUrl, endpoint, ...params);
};

