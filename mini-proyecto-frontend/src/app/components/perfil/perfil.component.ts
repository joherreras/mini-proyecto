
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EstudiantesService } from '../../services/estudiantes.service'
import { Estudiante } from 'src/app/interfaces/estudiante.model';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {


  //Elaboracion de la tabla
  estudiantes: Estudiante[] = [];
  cursos: string[] = ['PROGRAMA TU FUTURO'];
  columnasAMostrar: string[] = ['rut', 'nombres', 'apellidos', 'correo', 'idCurso', 'opciones']



  //Constructor
  constructor(private service: EstudiantesService) { }


  //Carga inicial

  ngOnInit(): void {
    this.service.obtenerEstudiantes().subscribe(estudiantes => this.estudiantes = estudiantes);
    console.log(this.estudiantes);
  }


  //Metodo Eliminar
  eliminar(i: number): void {
    let temp = this.estudiantes[i];
    console.log(temp.rut);
    this.service.borrarEstudiante(temp.rut).subscribe();
    //Actualiza la tabla
    this.estudiantes = this.estudiantes.filter(c => c.rut != temp.rut);
  }


  //Metodo Editar

  cambios: Estudiante = {
    rut: '',
    nombres: '',
    apellidos: '',
    correo: '',
    contrasenha: '',
    idCurso: ''
  };

  index = null;
  guardar(i: number) {
    this.index = i;
  }

  editar(): void {
    let body = this.estudiantes[this.index];
    let rut = body.rut;
    console.log(this.cambios.idCurso)

    this.service.editarEstudiante(rut, this.cambios).subscribe(resp => console.log("changes"),
      error => {
        if (error.status == 409) {
          alert("EL CORREO YA ESTA REGISTRADO")
        }
      });
    this.ngOnInit();
  }

}
