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
        for (rating in ratingArray) {
            // body of loop
        }
        listOfTodos.add(movie2(1, "","PPP-A"))
    }

    fun addTodos(newMovie: movie2) {
        listOfTodos.add(newMovie)
    }

    fun getTodos() = listOfTodos
}