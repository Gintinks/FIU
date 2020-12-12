package com.example.proyekakhir

class MovieRepository(
    ) {

    private val listOfTodos = mutableListOf<movie2>()
    init {
//        for (i in 0..ratingArray.size-1) {
//            // body of loop\
//            listOfTodos.add(movie2(i, nameArray.get(i),dateArray.get(i),synopsisArray.get(i) ,
//                Integer.parseInt(ratingArray.get(i)), posterArray.get(i)))
//        }

    }

    fun addTodos(newMovie: movie2) {
        listOfTodos.add(newMovie)
    }

    fun getTodos() = listOfTodos
}