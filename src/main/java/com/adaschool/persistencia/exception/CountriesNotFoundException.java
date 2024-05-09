package com.adaschool.persistencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CountriesNotFoundException extends ResponseStatusException {
    public CountriesNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "contrie with ID: " + id + " not found");
    }
}
