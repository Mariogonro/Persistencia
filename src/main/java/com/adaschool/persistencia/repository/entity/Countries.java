package com.adaschool.persistencia.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    public Countries(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Countries() {
    }


    public Countries(CountriesDto countriesDto) {
        this.name = countriesDto.getName();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
