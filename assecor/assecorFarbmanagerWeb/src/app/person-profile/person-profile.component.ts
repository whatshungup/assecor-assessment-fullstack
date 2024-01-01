import {Person} from "../model/person";
import {PersonService} from "../service/person-service.service";
import {ActivatedRoute} from "@angular/router";
import {Component} from "@angular/core";

@Component({
  selector: 'person-profile',
  templateUrl: './person-profile.component.html',
  styleUrls: ['./person-profile.component.css']
})
export class PersonProfileComponent{

  person: Person;


  constructor(private personService: PersonService, private route: ActivatedRoute,) {
    this.route.params.subscribe( params =>
    this.personService.findPerson(params['id']).subscribe(data => {
      this.person = data;
    })
    )
  }
}
