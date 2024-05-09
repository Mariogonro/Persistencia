package com.adaschool.persistencia.service.impl;

import com.adaschool.persistencia.repository.CountriesRepository;
import com.adaschool.persistencia.repository.entity.Countries;
import com.adaschool.persistencia.service.ICountriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService implements ICountriesService {
    private final CountriesRepository userRepository;

    public CountriesService(CountriesRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Countries> all() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Countries> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Countries save(Countries countries) {
        return userRepository.save(countries);
    }

    @Override
    public Countries update(Long id, Countries countries) {
        return userRepository.save(countries);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
