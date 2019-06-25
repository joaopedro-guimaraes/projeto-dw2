import { CurriculoComponent } from './curriculo/curriculo.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlunoComponent } from './aluno.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';

const childRoutes: Routes = [
  { path: 'cadastro', component: CadastroAlunoComponent },
  { path: 'editar', component: CurriculoComponent }
];

const routes: Routes = [
  { path: '', component: AlunoComponent, children: childRoutes }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
