package com.cts.springlearn.model;

import lombok.Data;

@Data
public class Country {
    private String code;
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}