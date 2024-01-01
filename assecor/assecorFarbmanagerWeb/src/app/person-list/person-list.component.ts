import { Component, OnInit } from '@angular/core';
import {Person} from "../model/person";
import {PersonService} from "../service/person-service.service";
import {Sort} from '@angular/material/sort';
import {COLORS} from "../model/colors";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";

@Component({
  selector: 'person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Person[]
  hideColumns = false;
  readonly COLORS = COLORS;
  constructor(private personService: PersonService,
              private breakpointObserver: BreakpointObserver) {
  }

  ngOnInit() {
    this.getAllPersons()

    this.breakpointObserver.observe([
      Breakpoints.HandsetPortrait,
      Breakpoints.TabletPortrait,
      Breakpoints.Small,
      Breakpoints.WebPortrait
    ])
      .subscribe(result => {

        this.hideColumns = false;

        if (result.matches) {
          this.hideColumns = true;
        }
      });
  }

  sortData(sort: Sort) {
    const data = this.persons;
    if (!sort.active || sort.direction === '') {
      return;
    }

    this.persons = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      let sortActive = sort.active as keyof Person
      if(sortActive == "color"){
        return this.compare(a["color"].id, b["color"].id, isAsc)
      }
      return this.compare(a[sortActive], b[sortActive], isAsc)
    });
  }
  compare(a: number | string, b: number | string, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }

  colorSelected(colorId : string) {
    this.personService.findAllByColor(colorId).subscribe(data => {
      this.persons = data;
    });
  }

  getAllPersons() {
    this.personService.findAll().subscribe(data => {
      this.persons = data;
    });
  }
}
