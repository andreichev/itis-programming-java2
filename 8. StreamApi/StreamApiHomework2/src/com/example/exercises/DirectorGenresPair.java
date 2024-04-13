package com.example.exercises;

import com.example.domain.Director;
import com.example.domain.Genre;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
record DirectorGenresPair(Director director,List<Genre> genres) { }
