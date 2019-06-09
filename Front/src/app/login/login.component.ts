import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

import { LoginModel } from './../core/models/login.model';
import { UserModel } from './../core/models/user.model';
import { LoginService } from './../core/services/login.service';
import { UserService } from './../core/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  hasError = false;
  hasLoading = false;
  labelEmail = 'Email:';
  labelSenha = 'Senha:';
  labelButton = 'Entrar';
  step = 0;
  title = 'Projeto DW2 - Login';

  alert = {
    type: 'danger',
    msg: `Usúario ou senha incorreto, tente novamente`,
  };

  loginForm = new FormGroup({
    'nomeUsuario': new FormControl(null),
    'email': new FormControl(null),
    'senha': new FormControl(null),
    'tipoUsuario': new FormControl(null),
  });

  login = {} as LoginModel;
  user = {} as UserModel;

  constructor(
    private readonly loginService: LoginService,
    private readonly router: Router,
    private readonly userService: UserService,
  ) { }

  ngOnInit() {}

  primeiroAcesso() {
    this.step = 1;
    this.title = 'Cadastro de usuario';
    this.labelEmail = 'Digite seu email de acesso:';
    this.labelSenha = 'Digite uma senha de acesso:';
    this.labelButton = 'Cadastrar';
  }

  doLogin() {
    this.loginService.login(this.login)
      .subscribe(
        res => {
          this.user = res;
        },
        error => {
          this.hasError = true;
        },
        () => {
          localStorage.setItem('user', JSON.stringify(this.user));
          this.router.navigate(['/home']);
        }
      );
  }

  cadastrar() {
    this.userService.cadastrar(this.user)
      .subscribe(
        res => {
          console.log(res);
        },
        error => {
          this.hasError = true;
        },
        () => {
          this.labelEmail = 'Email:';
          this.labelSenha = 'Senha:';
          this.labelButton = 'Entrar';
          this.title = 'Projeto DW2 - Login';
          this.step = 0;
        }
      );
  }

  onSubmit() {
    if (this.step === 0) {
      this.login.email = this.loginForm.controls.email.value;
      this.login.password =  this.loginForm.controls.senha.value;
      this.doLogin();
    }
    if (this.step === 1) {
      this.user.username =  this.loginForm.controls.nomeUsuario.value;
      this.user.userType = this.loginForm.controls.tipoUsuario.value;
      this.user.email = this.loginForm.controls.email.value;
      this.user.password = this.loginForm.controls.senha.value;
      this.cadastrar();
    }
  }

}
