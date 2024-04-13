package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Group the dictionary words by their first three letters

	}
}
