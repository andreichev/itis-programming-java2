package com.example.exercises;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		Stream<ContinentCityPair> pairs = countryDao.findAllCountries().stream()
				.flatMap(country -> country.getCities()
						.stream().map(city -> new ContinentCityPair(country.getContinent(), city))
				);

		Map<String, City> map = pairs.collect(Collectors.toMap(
				ContinentCityPair::continent,
				ContinentCityPair::city,
				(o, n) -> o.getPopulation() > n.getPopulation() ? o : n
		));

		map.forEach((continent, city) -> System.out.println(continent + ": " + city.getPopulation()));
	}
}