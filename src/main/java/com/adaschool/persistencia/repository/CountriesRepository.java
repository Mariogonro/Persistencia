package com.adaschool.persistencia.repository;

import com.adaschool.persistencia.repository.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long> {
}
