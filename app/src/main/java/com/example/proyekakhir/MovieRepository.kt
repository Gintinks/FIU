package com.example.proyekakhir

class MovieRepository(mainActivity: MainActivity) {
    private var movies = mutableListOf<MovieModel>()

    fun getMovies() = movies

    fun addMovies(newMovie: MovieModel) {
        movies.add(newMovie)
    }


    init {
        val ratingArray = mainActivity.resources.getStringArray(R.array.movie_rating)
        val nameArray = mainActivity.resources.getStringArray(R.array.movie_title)
        val synopsisArray = mainActivity.resources.getStringArray(R.array.movie_synopsis)
        val dateArray = mainActivity.resources.getStringArray(R.array.movie_release_date)
        val imageArray = mainActivity.resources.obtainTypedArray(R.array.movie_poster)
        val myImageList = intArrayOf(R.drawable.poster_aquaman,R.drawable.poster_avengerinfinity,R.drawable.poster_birdbox,
            R.drawable.poster_bumblebee,R.drawable.poster_dragon,R.drawable.poster_glass,R.drawable.poster_mortalengine,R.drawable.poster_robinhood
            ,R.drawable.poster_spiderman,R.drawable.poster_venom)
        movies.clear()

        for(i in ratingArray.indices){
            movies.add(MovieModel(i, nameArray[i], dateArray[i], synopsisArray[i], ratingArray[i],myImageList[i]))
        }
    }

}