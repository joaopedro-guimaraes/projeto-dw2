import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.scss']
})
export class EmpresaComponent implements OnInit {

  abas: any;
  hiddenAbas;

  constructor() { }

  ngOnInit() {
    this.hiddenAbas = false;
  }

  onActivate(componentReference) {
    componentReference.abas.subscribe(
        (res) => {
          this.abas = res,
          this.hiddenAbas = true;
        },
      );  
    }


}
