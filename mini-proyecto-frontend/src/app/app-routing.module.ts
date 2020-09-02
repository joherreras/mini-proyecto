import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RegistroComponent } from "./components/registro/registro.component";
import { PerfilComponent } from "./components/perfil/perfil.component";
import { PortalComponent } from "./components/portal/portal.component";
import { CursosComponent } from "./components/cursos/cursos.component";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "registro", component: RegistroComponent },
  //{ path: "login", component: LoginComponent },
  { path: "perfil", component: PerfilComponent },
  { path: "portal", component: PortalComponent }
  //{ path: "cursos", component: CursosComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
