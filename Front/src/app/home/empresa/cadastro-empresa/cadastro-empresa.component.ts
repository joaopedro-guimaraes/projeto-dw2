import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { EstadosCidades, Estado } from 'src/app/core/models';
import { UtilsService, EmpresaService } from 'src/app/core/services';
import { EmpresaCadastroModel } from 'src/app/core/models/empresa.model';

@Component({
  selector: 'app-cadastro-empresa',
  templateUrl: './cadastro-empresa.component.html',
  styleUrls: ['./cadastro-empresa.component.scss']
})
export class CadastroEmpresaComponent implements OnInit {

  @Output() abas = new EventEmitter();

  empresaForm = new FormGroup({
    'cnpj': new FormControl(null),
    'companyName': new FormControl(null),
    'address': new FormControl(null),
    'number': new FormControl(null),
    'city': new FormControl(null),
    'neighborhood': new FormControl(null),
    'state': new FormControl(null),
    'cep': new FormControl(null),
    'telephone': new FormControl(null),
    'responsible': new FormControl(null),
  });

  estadosCidades: EstadosCidades;
  user;
  estado: Estado;

  constructor(
    private readonly empresaService: EmpresaService,
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
    const cidades = this.estadosCidades.estados.filter(estado => estado.nome === this.empresaForm.controls.state.value);
    this.estado = cidades[0];
  }

  onSubmit() {
    let data: EmpresaCadastroModel = {
      userCompany: {
        idUser: this.user.idUser,
      },
      cnpj: this.empresaForm.value.cnpj,
      companyName: this.empresaForm.value.companyName,  
      address: this.empresaForm.value.address,
      number: this.empresaForm.value.number,
      city: this.empresaForm.value.city,
      neighborhood: '',
      state: this.empresaForm.value.state,
      cep: this.empresaForm.value.cep,
      telephone: this.empresaForm.value.telephone,
      responsible: this.empresaForm.value.responsible
    }

    this.empresaService.cadastrar(data)
    .subscribe(
      res => res,
      error => console.error(error),
    )
  }

}
