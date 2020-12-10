package com.example.proyekakhir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewMovie(val movieRepo: MovieRepository): ViewModel() {

    var listOfTodos = MutableLiveData<List<movie2>>()

    fun getTodos(): LiveData<List<movie2>> {
        listOfTodos.value = movieRepo.getTodos()
        return listOfTodos
    }
    fun addTodos(newMahasiswa : movie2){
        movieRepo.addTodos(newMahasiswa)
        listOfTodos.value = movieRepo.getTodos()
    }
}