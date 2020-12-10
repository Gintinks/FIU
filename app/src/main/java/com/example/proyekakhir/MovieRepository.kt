package com.example.proyekakhir

class MovieRepository(
    ratingArray: kotlin.Array<String>,
    posterArray: kotlin.Array<String>,
    nameArray: kotlin.Array<String>,
    synopsisArray: kotlin.Array<String>,
    dateArray: kotlin.Array<String>
) {

    private val listOfTodos = mutableListOf<movie2>()
    init {
        for (i in 0..ratingArray.size-1) {
            // body of loop\
            ratingArray.get(i)
        }
        listOfTodos.add(movie2(1, "","PPP-A"))
    }

    fun addTodos(newMovie: movie2) {
        listOfTodos.add(newMovie)
    }

    fun getTodos() = listOfTodos
}