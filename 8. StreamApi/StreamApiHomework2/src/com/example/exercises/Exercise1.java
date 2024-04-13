package com.example.exercises;

import com.example.domain.Director;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Map<Director, Long> numberOfMovies = movieService.findAllMovies().stream()
				.flatMap(movie -> movie.getDirectors().stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		numberOfMovies.forEach((director, count) -> {
			System.out.println(director.getName() + ": " + count);
		});
	}

}
