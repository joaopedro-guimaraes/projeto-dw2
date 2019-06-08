import { LoginService } from './../core/services/login.service';
import { LoginModel } from './../core/models/login.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  step = 0;
  labelEmail = 'Email:';
  labelSenha = 'Senha:';
  labelButton = 'Entrar';
  title = 'Projeto DW2 - Login';

  loginForm = new FormGroup({
    'nomeUsuario': new FormControl(null),
    'email': new FormControl(null),
    'senha': new FormControl(null),
    'tipoUsuario': new FormControl(null),
  });

  login = {} as LoginModel;

  constructor(
    private readonly loginService: LoginService,
    private readonly router: Router,
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
      .subscribe(res => {
        console.log(res);
      });
  }

  onSubmit() {
    if (this.step === 0) {
      console.log('Logica de login');
      this.login.email = this.loginForm.controls.email.value;
      this.login.password =  this.loginForm.controls.senha.value;
      this.doLogin();
      // this.router.navigate(['home']);
    }
    if (this.step === 1) {
      console.log('Logica de cadastrar usuario');
      console.log(this.loginForm.controls.nomeUsuario.value);
      console.log(this.loginForm.controls.tipoUsuario.value);
      console.log(this.loginForm.controls.email.value);
      console.log(this.loginForm.controls.senha.value);
      this.labelEmail = 'Email:';
      this.labelSenha = 'Senha:';
      this.labelButton = 'Entrar';
      this.title = 'Projeto DW2 - Login';
      this.step = 0;
    }
  }

}
