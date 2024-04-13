package com.example.dao;

import com.example.domain.Country;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public interface CountryDao {
    Country findCountryByCode(String code);

    Country removeCountry(Country country);

    Country addCountry(Country country);

    Country updateCountry(Country country);

    List<Country> findAllCountries();

    List<Country> findCountriesByContinent(String continent);

    Set<String> getAllContinents();
}