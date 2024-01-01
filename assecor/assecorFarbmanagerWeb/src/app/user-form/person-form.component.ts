import { Component } from '@angular/core';
import {Router } from '@angular/router';
import {Person} from "../model/person";
import {PersonService} from "../service/person-service.service";
import {COLORS} from "../model/colors";

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent {

  person: Person;
  protected readonly COLORS = COLORS;

  constructor(
    private router: Router,
    private personService: PersonService) {
    this.person = new Person();
  }

  onSubmit() {
    this.personService.save(this.person).subscribe(() => this.gotoOverview());
  }

  gotoOverview() {
    this.router.navigate(['/overview']);
  }

}
