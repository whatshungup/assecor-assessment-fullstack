import { Pipe, PipeTransform } from '@angular/core';
import {Person} from "../model/person";

@Pipe({ name: 'person' })
export class PersonPipe implements PipeTransform {
  transform(values: Person[], filter: string): Person[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    return values.filter((value: Person) => {
      const nameFound =
        value.name.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const lastNameFound =
        value.lastName.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const cityFound =
        value.city.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const zipcodeFound =
        value.zipcode.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const colorFound =
        value.color.id.toString().indexOf(filter.toLowerCase()) !== -1;

      if (nameFound || colorFound || lastNameFound ||cityFound || zipcodeFound) {
        return value;
      }

      return null;
    });


  }
}
