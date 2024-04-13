package com.example.dictionary.exercises;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Count the vowels used in words
	}
}
