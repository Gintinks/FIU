package com.example.proyekakhir

class MovieCommentRepo(
    commentActivity: CommentActivity,
    id: String,
    totalRating: Int
){
    var movieCommentList = mutableListOf<MovieCommentModel>()

    init {
        val id_comment = commentActivity.resources.getStringArray(R.array.id_movie)
        val nama = commentActivity.resources.getStringArray(R.array.nama)
        val comment = commentActivity.resources.getStringArray(R.array.comment)

        // val rating = resources.getStringArray(R.array.c_rating)
        var totalRating = totalRating
        movieCommentList.clear()
        for(i in id_comment.indices){
            if(id_comment[i]==id) {
                movieCommentList.add(MovieCommentModel(id_comment[i], nama[i], comment[i]))
                totalRating += 1
            } else if(totalRating==0){
                totalRating += 1
            }
        }
    }

    fun getmovieCommentList() = movieCommentList

    fun tambahMovieComment(newMovieComment: MovieCommentModel){
        movieCommentList.add(newMovieComment)
    }
}