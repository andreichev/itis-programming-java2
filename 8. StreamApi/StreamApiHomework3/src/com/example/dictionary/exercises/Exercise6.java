package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the first word starting with the letter a, and ends with the letter z
	}

}
