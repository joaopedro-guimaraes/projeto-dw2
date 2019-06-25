import { UtilsService } from './../../../core/services/utils.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { EstadosCidades, Estado } from 'src/app/core/models';
import { CadastroModel } from 'src/app/core/models/aluno.model';
import { AlunoService } from 'src/app/core/services';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.scss']
})
export class CadastroAlunoComponent implements OnInit {

  @Output() abas = new EventEmitter();

  cadastroAlunoForm = new FormGroup({
    'prontuario': new FormControl(null),
    'nomeUsuario': new FormControl(null),
    'email': new FormControl(null),
    'senha': new FormControl(null),
    'tipoUsuario': new FormControl(null),
    'cep': new FormControl(null),
    'logradouro': new FormControl(null),
    'numero': new FormControl(null),
    'estados': new FormControl(null),
    'cidades': new FormControl(null),
    'telefone': new FormControl(null),
    'curso': new FormControl(null),
    'data': new FormControl(null),
  });

  estadosCidades: EstadosCidades;
  user;
  estado: Estado;

  constructor(
    private readonly alunoService: AlunoService,
    private readonly utilsService: UtilsService,
  ) { }

  ngOnInit() {
    this.user =  JSON.parse(localStorage.getItem('user'));
    this.abas.emit({
      'abas' : [
        {
          nome : 'Visualizar',
          router : 'cadastro',
        },
        {
          nome : 'Editar',
          router : 'editar',
        }
      ]
    });

    this.utilsService.getCidadesEstados().subscribe(res => {
      this.estadosCidades = res;
    });
  }

  getCidades() {
    const cidades = this.estadosCidades.estados.filter(estado => estado.nome === this.cadastroAlunoForm.controls.estados.value);
    this.estado = cidades[0];
  }

  onSubmit() {
    let cadastroAluno: CadastroModel = {
      userStudent: {
        idUser: this.user.idUser,
      },
      register: this.cadastroAlunoForm.controls.prontuario.value,
      name: this.cadastroAlunoForm.controls.nomeUsuario.value,  
      address: this.cadastroAlunoForm.controls.logradouro.value,
      number: this.cadastroAlunoForm.controls.numero.value,
      city: this.cadastroAlunoForm.controls.cidades.value,
      neighborhood: '',
      state: this.cadastroAlunoForm.controls.estados.value,
      cep: this.cadastroAlunoForm.controls.cep.value,
      telephone: this.cadastroAlunoForm.controls.telefone.value,
      course: this.cadastroAlunoForm.controls.curso.value,
      dataIngresso: this.cadastroAlunoForm.controls.data.value,
    }

    this.alunoService.cadastrar(cadastroAluno)
    .subscribe(
      res => res,
      error => console.error(error),
    )
  }

}
