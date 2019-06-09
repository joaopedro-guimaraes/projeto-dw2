import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss']
})
export class AlunoComponent implements OnInit {


  abas = '';

  constructor() { }

  ngOnInit() {
  }

  onActivate(componentReference) {
    console.log(componentReference);
    componentReference.anyFunction();
    componentReference.abas.subscribe( res => this.abas = res);
    console.log(this.abas);
  }

}
