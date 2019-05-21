import { CurriculoComponent } from './curriculo/curriculo.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlunoComponent } from './aluno.component';

const childRoutes: Routes = [
  { path: '', component: CurriculoComponent }
];

const routes: Routes = [
  { path: '', component: AlunoComponent, children: childRoutes }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
