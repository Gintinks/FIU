package com.example.proyekakhir

class MovieCommentRepo {
    var movieCommentList = mutableListOf<MovieCommentModel>()


    init {
    }

    fun getmovieCommentList() = movieCommentList

    fun tambahMovieComment(newMovieCommente: MovieCommentModel){
        movieCommentList.add(newMovieCommente)
    }
}