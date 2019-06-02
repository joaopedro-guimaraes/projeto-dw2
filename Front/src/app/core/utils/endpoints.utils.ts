export const enum DataEndpoints {
  EstadosCidades = 'estados-cidades.json',
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
