import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoComponent } from './aluno.component';
import { CurriculoComponent } from './curriculo/curriculo.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AlunoComponent, CurriculoComponent, CadastroAlunoComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AlunoRoutingModule
  ]
})
export class AlunoModule { }
