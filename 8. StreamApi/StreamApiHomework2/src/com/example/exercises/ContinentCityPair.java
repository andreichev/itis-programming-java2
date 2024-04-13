package com.example.exercises;

import com.example.domain.City;

import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public record ContinentCityPair(String continent,City city) implements Comparable<ContinentCityPair>{

	@Override
	public int compareTo(ContinentCityPair other) {
		return this.city.getPopulation()-other.city.getPopulation();
	}

	public static void printEntry(String continent,Optional<ContinentCityPair> pair) {
		System.out.printf("%s: %s\n",continent,pair.get().city());
	}

}
