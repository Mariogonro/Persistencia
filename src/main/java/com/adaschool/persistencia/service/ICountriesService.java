package com.adaschool.persistencia.service;

import com.adaschool.persistencia.repository.entity.Countries;

import java.util.List;
import java.util.Optional;

public interface ICountriesService {
    List<Countries> all();
    Optional<Countries> findById(Long id);
    Countries save(Countries countries);
    Countries update(Long id, Countries countries);
    void deleteById(Long id);
}
