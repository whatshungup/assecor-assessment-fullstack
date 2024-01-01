import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './user-form/person-form.component';
import {PersonProfileComponent} from "./person-profile/person-profile.component";

const routes: Routes = [
  { path: 'overview', component: PersonListComponent },
  { path: 'profile/:id', component: PersonProfileComponent },
  { path: 'addPerson', component: PersonFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
