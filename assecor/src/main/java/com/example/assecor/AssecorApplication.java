package com.example.assecor;

import com.example.assecor.generator.PersonDatenbestandGenerator;
import com.example.assecor.persistence.ColorEntity;
import com.example.assecor.persistence.ColorRepository;
import com.example.assecor.persistence.Colors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;


@SpringBootApplication
public class AssecorApplication {


    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext applicationContext = SpringApplication.run(AssecorApplication.class, args);
        PersonDatenbestandGenerator service = applicationContext.getBean(PersonDatenbestandGenerator.class);
        ColorRepository colorRepository = applicationContext.getBean(ColorRepository.class);
        for(ColorEntity colorEntity : Colors.COLORS){
            colorRepository.save(colorEntity);
        }
        service.readPersonData();
    }

}
