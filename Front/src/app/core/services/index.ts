import { AlunoService }  from './aluno.service';
import { EmpresaService } from './empresa.service';
import { EstagioService } from './estagio.service';
import { LoginService } from './login.service';
import { UserService } from './user.service';
import { UtilsService } from './utils.service';

export * from './aluno.service';
export * from './empresa.service';
export * from './estagio.service';
export * from './login.service';
export * from './user.service';
export * from './utils.service';


export const services = [
  AlunoService,
  EmpresaService,
  EstagioService,
  LoginService,
  UserService,
  UtilsService,
];
