package com.auca__mis.service;

import com.auca__mis.model.Country;

import java.util.List;

public interface ICountryService {
    Country saveCountry(Country country);
    public List<Country> findAll();
}
