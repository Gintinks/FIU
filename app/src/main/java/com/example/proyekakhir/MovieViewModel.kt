package com.example.proyekakhir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(val movieRepo: MovieRepository): ViewModel() {
    var movies = MutableLiveData<List<MovieModel>>()
    fun getMovie(): LiveData<List<MovieModel>>{
        movies.value = movieRepo.getMovies()
        return movies
    }
    fun addMovies (newMovie: MovieModel){
        movieRepo.addMovies(newMovie)
        movies.value = movieRepo.getMovies()
    }
}