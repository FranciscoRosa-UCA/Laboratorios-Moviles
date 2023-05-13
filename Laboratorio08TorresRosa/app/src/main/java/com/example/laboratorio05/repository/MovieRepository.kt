package com.example.laboratorio05.repository

import com.example.laboratorio05.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)

}