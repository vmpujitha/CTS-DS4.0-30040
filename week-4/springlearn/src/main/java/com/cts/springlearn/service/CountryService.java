package com.cts.springlearn.service;

import com.cts.springlearn.model.Country;
import com.cts.springlearn.exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private static List<Country> countries = new ArrayList<>();

    static {
        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("JP", "Japan"));
        countries.add(new Country("DE", "Germany"));
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException());
    }

    public List<Country> getAllCountries() {
        return countries;
    }
}