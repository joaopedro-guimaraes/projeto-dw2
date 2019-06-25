import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpresaComponent } from './empresa.component';
import { VagaComponent } from './vaga/vaga.component';
import { CadastroEmpresaComponent } from './cadastro-empresa/cadastro-empresa.component';

const childRoutes: Routes = [
  { path: 'vaga', component: VagaComponent },
  { path: 'cadastro', component: CadastroEmpresaComponent },
];

const routes: Routes = [
  { path: '', component: EmpresaComponent, children: childRoutes }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresaRoutingModule { }
