import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Person} from "../model/person";
import {Observable} from "rxjs";

@Injectable()
export class PersonService {

  private PERSON_URL_BASE: string
  private PERSONS_URL: string
  private SAVE_PERSON: string

  constructor(private http: HttpClient) {
    this.PERSON_URL_BASE = 'http://localhost:8080'
    this.PERSONS_URL = this.PERSON_URL_BASE + "/persons"
    this.SAVE_PERSON = this.PERSON_URL_BASE + "/savePerson"
  }

  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.PERSONS_URL);
  }

  public findAllByColor(color : string): Observable<Person[]> {
    return this.http.get<Person[]>(this.PERSONS_URL + "/color/" + color);
  }

  public findPerson(id : string): Observable<Person> {
    return this.http.get<Person>(this.PERSONS_URL + "/" + id);
  }

  public save(user: Person) {
    return this.http.post<Person>(this.SAVE_PERSON, user);
  }

}
