package com.example.proyekakhir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieCommentViewModel (val movieRepo: MovieCommentRepo): ViewModel() {
    var movieComments = MutableLiveData<List<MovieCommentModel>>()

    fun getmovieComments(): LiveData<List<MovieCommentModel>> {
        movieComments.value = movieRepo.getmovieCommentList()
        return movieComments
    }

    fun tambahMovieComments(newMovieCommente : MovieCommentModel){
        movieRepo.tambahMovieComment(newMovieCommente)
        movieComments.value = movieRepo.getmovieCommentList()
    }
}