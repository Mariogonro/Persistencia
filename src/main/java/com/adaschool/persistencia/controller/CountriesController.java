package com.adaschool.persistencia.controller;

import com.adaschool.persistencia.repository.CountriesRepository;
import com.adaschool.persistencia.repository.entity.Countries;
import com.adaschool.persistencia.service.impl.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CountriesController {
    @Autowired
    private CountriesRepository countriesRepository;

    @GetMapping("/countries")
    public List<Countries> getAllCountries() {
        return countriesRepository.findAll();
    }

    @GetMapping("countries/{id}")
    public ResponseEntity<Countries> findById(@PathVariable("id") Long id) {
        Optional<Countries> countries  = countriesRepository.findById(id);
        return ResponseEntity.ok(countries.get());
    }

    @PostMapping("/countries")
    public Countries createCountries(@RequestBody Countries newCountries) {
        return countriesRepository.save(newCountries);
    }

    @PutMapping("countries/{id}")
    public Countries updateCountries(@RequestBody Countries newCountries, @PathVariable Long id) {
        return countriesRepository.findById(id)
                .map(countries -> {
                    countries.setId(id);
                    countries.setName(newCountries.getName());
                    return countriesRepository.save(countries);
                })
                .orElseGet(() -> {
                    return countriesRepository.save(newCountries);
                });
    }

    @DeleteMapping("countries/{id}")
    public void deleteUser(@PathVariable Long id) {
        countriesRepository.deleteById(id);
    }
}
