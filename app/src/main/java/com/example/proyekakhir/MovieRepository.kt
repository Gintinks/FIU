package com.example.proyekakhir

import java.lang.reflect.Array

class MovieRepository {

    private val listOfTodos = mutableListOf<movie2>()
    init {
        for (item in collection) {
            // body of loop
        }
        listOfTodos.add(movie2(1, "","PPP-A"))
    }

    fun addTodos(newMovie: movie2) {
        listOfTodos.add(newMovie)
    }

    fun getTodos() = listOfTodos
}