import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Estudiante } from 'src/app/interfaces/estudiante.model';
import { EstudiantesService } from 'src/app/services/estudiantes.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  constructor(private EstudiantesService: EstudiantesService, private router: Router) { }


  estudiantes: Estudiante[] = [];

  estudiante: Estudiante = {
    rut: '',
    nombres: '',
    apellidos: '',
    correo: '',
    contrasenha: '',
    idCurso: null
  };

  validacion() {
    //console.log("LLEGUE AQUI TAMBIEN");
    if (this.estudiante.contrasenha.valueOf) {
      console.log(this.estudiante.contrasenha.valueOf)
    }



  }

  ngOnInit(): void {
    this.EstudiantesService.obtenerEstudiantes().subscribe(estudiantes => this.estudiantes = estudiantes);
    console.log(this.estudiantes);

  }


  mostrar() {
    this.EstudiantesService.obtenerEstudiantes().subscribe(estudiantes => this.estudiantes = estudiantes);
    console.log(this.estudiantes);
  }

  registrar() {
    console.log(this.estudiante);
    this.EstudiantesService.registrarEstudiante(this.estudiante).
      subscribe(estudiante => this.estudiantes.push(estudiante),
        error => {
          if (error.status == 409) {
            console.log("Correo ya")
            alert("EL CORREO YA ESTA REGISTRADO, INTENTE CON OTRO.")

          }
        })
  }
}
