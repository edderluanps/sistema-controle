import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { servicoprestado } from './servicos-prestados/servicosprestados';

@Injectable({
  providedIn: 'root'
})
export class ServicosPrestadosService {

  apiURL: string = environment.baseApiURL + "/api/servicos-prestados";

  constructor(private http: HttpClient) { }

  salvar(servicosPrestados: servicoprestado) : Observable<servicoprestado>{ 
    return this.http.post<servicoprestado>(this.apiURL, servicosPrestados);
  }
}
