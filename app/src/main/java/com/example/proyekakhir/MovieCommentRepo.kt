package com.example.proyekakhir

class MovieCommentRepo {
    var movieCommentList = mutableListOf<MovieCommentModel>()


    init {
        movieCommentList.add(MovieCommentModel("1", "yudi", "filmnya kek anjing"))
    }

    fun getmovieCommentList() = movieCommentList

    fun tambahMovieComment(newMovieCommente: MovieCommentModel){
        movieCommentList.add(newMovieCommente)
    }
}