import { UtilsService } from './../../../core/services/utils.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { EstadosCidades, Estado } from 'src/app/core/models';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.scss']
})
export class CadastroAlunoComponent implements OnInit {

  @Output() abas = new EventEmitter();

  cadastroAlunoForm = new FormGroup({
    'nomeUsuario': new FormControl(null),
    'email': new FormControl(null),
    'senha': new FormControl(null),
    'tipoUsuario': new FormControl(null),
    'cep': new FormControl(null),
    'logradouro': new FormControl(null),
    'numero': new FormControl(null),
    'estados': new FormControl(null),
    'cidades': new FormControl(null),
  });

  estadosCidades: EstadosCidades;
  estado: Estado;

  constructor(
    private readonly utilsService: UtilsService,
  ) { }

  ngOnInit() {
    this.abas.emit({
      'abas' : [
        {
          nome : 'Visualizar',
          router : '/cadastro',
        },
        {
          nome : 'Editar',
          router : '/editar',
        }
      ]
    });

    this.utilsService.getCidadesEstados().subscribe(res => {
      this.estadosCidades = res;
    });
  }

  anyFunction() {
    console.log('Chamado do pai');
  }

  getCidades() {
    const cidades = this.estadosCidades.estados.filter(estado => estado.nome === this.cadastroAlunoForm.controls.estados.value);
    this.estado = cidades[0];
  }

}
