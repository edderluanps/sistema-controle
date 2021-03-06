import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from 'src/app/clientes/cliente';
import { ServicosPrestadosService } from 'src/app/servicos-prestados.service';
import { servicoprestado } from '../servicosprestados';

@Component({
  selector: 'app-servicos-prestados-form',
  templateUrl: './servicos-prestados-form.component.html',
  styleUrls: ['./servicos-prestados-form.component.css']
})
export class ServicosPrestadosFormComponent implements OnInit {

  clientes: Cliente[] = [];
  servico: servicoprestado;

  constructor(
    private clienteService : ClientesService,
    private servicoPrestadoService: ServicosPrestadosService
  ) { 
    this.servico = new servicoprestado();
  }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe( response => this.clientes = response);
  }

  onSubmit(){
    this.servicoPrestadoService.salvar(this.servico).subscribe( response => console.log(response));
  }

}
