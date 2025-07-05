package com.cts.countryservice.repository;

import com.cts.countryservice.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContainingIgnoreCase(String namePart);
}
