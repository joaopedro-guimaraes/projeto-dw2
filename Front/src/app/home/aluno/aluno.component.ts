import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss']
})
export class AlunoComponent implements OnInit {


  abas: any;

  constructor() { }

  ngOnInit() {
  }

  onActivate(componentReference) {
    componentReference.abas.subscribe( res => this.abas = res);
  }

}
