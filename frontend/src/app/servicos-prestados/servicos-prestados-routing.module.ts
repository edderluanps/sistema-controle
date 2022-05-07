import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServicosPrestadosFormComponent } from './servicos-prestados-form/servicos-prestados-form.component';
import { ServicosPrestadosListaComponent } from './servicos-prestados-lista/servicos-prestados-lista.component';


const routes: Routes = [
  { path: 'servico-prestado-form', component: ServicosPrestadosFormComponent },
  { path: 'servico-prestado-lista', component: ServicosPrestadosListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicosPrestadosRoutingModule { }
