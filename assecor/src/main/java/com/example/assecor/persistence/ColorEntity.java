package com.example.assecor.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class ColorEntity implements Serializable {

    @Id
    private Long id;
    private String name;
    private String htmlCode;

    @JsonCreator
    public ColorEntity(@JsonProperty("id") Long id,@JsonProperty("name") String name,@JsonProperty("htmlCode") String htmlCode) {
        this.id = id;
        this.name = name;
        this.htmlCode = htmlCode;
    }

    public ColorEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
