import { LoginService } from './login.service';
import { UtilsService } from './utils.service';


export * from './login.service';
export * from './utils.service';


export const services = [
  LoginService,
  UtilsService,
];
