import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../../interfaces/estudiante.model';
import { EstudiantesService } from 'src/app/services/estudiantes.service'
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {
  contacto: FormGroup;
  estudiantes: Estudiante;
  submitted = false;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.contacto = this.formBuilder.group({
      rut: ['', Validators.required],
      nombres: ['', Validators.required],
      apellidoPaterno: ['', Validators.required],
      apellidoMaterno: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      contrasenha: ['', [Validators.required, Validators.minLength(4)]]
    });


  }


  get f() { return this.contacto.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.contacto.invalid) {
      return;
    }

    alert('Mensaje Enviado !')
  }



}
