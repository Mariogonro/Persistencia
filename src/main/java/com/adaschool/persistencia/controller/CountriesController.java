package com.adaschool.persistencia.controller;

import com.adaschool.persistencia.repository.CountriesRepository;
import com.adaschool.persistencia.repository.entity.Countries;
import com.adaschool.persistencia.repository.entity.CountriesDto;
import com.adaschool.persistencia.service.impl.CountriesService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {
    @Autowired
    private CountriesRepository countriesRepository;

    @GetMapping
    public List<Countries> getAllCountries() {
        return countriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Countries> findById(@PathVariable("id") Long id) {
        Optional<Countries> countries  = countriesRepository.findById(id);
        return ResponseEntity.ok(countries.get());
    }

    @PostMapping
    public Countries createCountries(@RequestBody  CountriesDto countriesDto) {
        Countries countries = new Countries(countriesDto);
        return countriesRepository.save(countries);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        countriesRepository.deleteById(id);
    }
}
