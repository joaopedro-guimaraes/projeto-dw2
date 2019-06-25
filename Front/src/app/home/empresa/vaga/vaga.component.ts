import { Component, OnInit, Output, EventEmitter, AfterViewInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { EstagioService } from 'src/app/core/services';
import { EstagioModel } from 'src/app/core/models';

@Component({
  selector: 'app-vaga',
  templateUrl: './vaga.component.html',
  styleUrls: ['./vaga.component.scss']
})
export class VagaComponent implements OnInit {

  @Output() abas = new EventEmitter();

  vagaForm = new FormGroup({
    description: new FormControl(null),
    requiredRequirements: new FormControl(null),
    desirableRequirements: new FormControl(null)
  })

  user;

  constructor(
    private estagioService: EstagioService,
  ) {}

  ngOnInit() {
    this.user =  JSON.parse(localStorage.getItem('user'));
    this.abas.emit({
      'abas' : [
        {
          nome : 'Cadastrar',
          router : 'vaga',
        },
        {
          nome : 'Visualizar',
          router : 'lista',
        }
      ]
    });
  }

  onSubmit() {
    let data: EstagioModel ={
      idCompany: this.user.idUser, 
      internship: {
        description: this.vagaForm.value.description,
        requiredRequirements: this.vagaForm.value.requiredRequirements,
        desirableRequirements: this.vagaForm.value.desirableRequirements

      } 
    }
    this.estagioService.cadastrar(data)
    .subscribe(
      (res) => {
        res;
      },
      error => {
        console.log(error);
    });
      
  }

}
