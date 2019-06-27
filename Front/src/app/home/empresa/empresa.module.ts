import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmpresaComponent } from './empresa.component';
import { EmpresaRoutingModule } from './empresa-routing.module';
import { VagaComponent } from './vaga/vaga.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CadastroEmpresaComponent } from './cadastro-empresa/cadastro-empresa.component';

@NgModule({
  declarations: [EmpresaComponent, VagaComponent, CadastroEmpresaComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    EmpresaRoutingModule
  ]
})
export class EmpresaModule { }
