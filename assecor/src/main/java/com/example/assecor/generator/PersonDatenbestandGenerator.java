package com.example.assecor.generator;

import com.example.assecor.persistence.ColorEntity;
import com.example.assecor.persistence.PersonEntity;
import com.example.assecor.persistence.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

import static com.example.assecor.persistence.Colors.COLORS;

@Service
public class PersonDatenbestandGenerator {
    private final PersonRepository personRepository;
    protected File folder;

    public PersonDatenbestandGenerator(PersonRepository personRepository) {
        this.personRepository = personRepository;
         this.folder = new File("src/main/resources/personData");
    }

    public void readPersonData() throws FileNotFoundException {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if(fileEntry.getName().contains(".csv"))
                readCsvFile(fileEntry);

        }
    }

    public void readCsvFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                PersonEntity person = getPersonFromLine(scanner.nextLine());
                if(person != null) {
                    this.personRepository.save(person);
                }
            }
        }
    }

    private PersonEntity getPersonFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add((rowScanner.next()));
            }
        }

        try {
            PersonEntity person = new PersonEntity();
            person.setLastName(values.get(0));
            person.setName(values.get(1));
            String[] adresse = values.get(2).split("\\s+");
            person.setZipcode(adresse[1]);
            person.setCity(adresse[2]);
            Long colorId = Long.valueOf(values.get(3).replace(" ", ""));
            Optional<ColorEntity> colorEntity = Arrays.stream(COLORS).filter(color -> color.getId().equals(colorId)).findFirst();
            colorEntity.ifPresent(person::setColor);
            return person;
        } catch (Exception e) {

        }
        return null;
    }

}
