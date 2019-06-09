export interface EstadosCidades {
  estados: Estado[];
}

export interface Estado {
  nome: string;
  sigla: string;
  cidades: string [];
}
