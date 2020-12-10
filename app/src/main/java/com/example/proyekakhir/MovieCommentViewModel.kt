package com.example.proyekakhir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieCommentViewModel (val mahasiswaRepo: MovieCommentRepo): ViewModel() {
    var movieComments = MutableLiveData<List<MovieCommentModel>>()

    fun getmovieComments(): LiveData<List<MovieCommentModel>> {
        movieComments.value = mahasiswaRepo.getmovieCommentList()
        return movieComments
    }

    fun tambahMovieComments(newMovieCommente : MovieCommentModel){
        mahasiswaRepo.tambahMovieComment(newMovieCommente)
        movieComments.value = mahasiswaRepo.getmovieCommentList()
    }
}