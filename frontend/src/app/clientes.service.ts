import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) {
  }

   salvar(cliente : Cliente) : Observable<Cliente>{
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }
  getClientes() : Observable<Cliente[]>{
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

}