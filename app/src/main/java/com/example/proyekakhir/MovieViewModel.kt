package com.example.proyekakhir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(val movieRepo: MovieRepository): ViewModel() {
    var movies = MutableLiveData<List<movie2>>()
    fun getMovie(): LiveData<List<movie2>>{
        movies.value = movieRepo.getMovies()
        return movies
    }
    fun addMovies (newMovie: movie2){
        movieRepo.addMovies(newMovie)
        movies.value = movieRepo.getMovies()
    }
}