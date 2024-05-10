package com.adaschool.persistencia.repository.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CountriesDto {
    private String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CountriesDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
