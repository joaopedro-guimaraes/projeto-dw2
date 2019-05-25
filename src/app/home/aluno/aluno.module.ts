import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoComponent } from './aluno.component';
import { CurriculoComponent } from './curriculo/curriculo.component';

@NgModule({
  declarations: [AlunoComponent, CurriculoComponent],
  imports: [
    CommonModule,
    AlunoRoutingModule
  ]
})
export class AlunoModule { }
