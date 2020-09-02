import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudiante } from '../interfaces/estudiante.model';
@Injectable({
  providedIn: 'root'
})
export class EstudiantesService {
  constructor(private http: HttpClient) { }


  Estudiantes: Estudiante[] = [];
  obtenerURL = "http://localhost:8080/api/estudiantes";
  apiURL = "http://localhost:8080/api/estudiante"

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  obtenerEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.obtenerURL);
  }


  registrarEstudiante(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.post<Estudiante>(this.apiURL, estudiante, this.httpOptions);
  }


  borrarEstudiante(rut: string): Observable<{}> {
    this.apiURL = `${this.apiURL}/${rut}`
    return this.http.delete(this.apiURL, this.httpOptions);
  }

  editarEstudiante(rut: string, body: Estudiante): Observable<{}> {
    this.apiURL = `${this.apiURL}/${rut}`;
    return this.http.put(this.apiURL, body);
  }

}