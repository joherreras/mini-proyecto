import { Directive } from '@angular/core';
import { NG_VALIDATORS, Validator } from '@angular/forms';

@Directive({
  selector: '[password]',
  providers: [{ provide: NG_VALIDATORS, useExisting: PasswordDirective, multi: true }]
})
export class PasswordDirective {


  validate(control: import("@angular/forms").AbstractControl): import("@angular/forms").ValidationErrors {
    const password = <string>control.value;

    if (!password) { return; }
    if (password.length < 4) { return; }


    if (!/\d/.test(password)) {
      return { 'password': { 'message': 'La contraseña debe incluir al menos 1 número' } }
    }

    if (!/\D/.test(password)) {
      return { 'password': { 'message': 'La contraseña debe incluir al menos 1 letra' } }
    }

    return null;


  }




  constructor() { }


}
