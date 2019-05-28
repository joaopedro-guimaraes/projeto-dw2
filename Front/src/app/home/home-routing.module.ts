import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';

const childRoutes: Routes = [
  { path: 'aluno', loadChildren: './aluno/aluno.module#AlunoModule' }
];

const routes: Routes = [
  { path: '', component: HomeComponent, children: childRoutes }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
