package com.example.proyekakhir

class MovieCommentRepo {
    var movieCommentList = mutableListOf<MovieCommentModel>()


    init {
        movieCommentList.add(MovieCommentModel("yulianus wayan Y.R", "filmnya jelek ajg"))
    }

    fun getmovieCommentList() = movieCommentList

    fun tambahMovieComment(newMovieCommente: MovieCommentModel){
        movieCommentList.add(newMovieCommente)
    }
}