package com.cts.countryservice.controller;

import com.cts.countryservice.entity.Country;
import com.cts.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/{code}")
    public ResponseEntity<Country> getByCode(@PathVariable String code) {
        return service.findByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return service.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        service.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}
