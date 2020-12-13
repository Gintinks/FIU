package com.example.proyekakhir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragComment: Fragment(R.layout.movie_comment)  {
    var comments : MutableList<MovieCommentModel> = mutableListOf()
    fun initData(){
        val id_comment = resources.getIntArray(R.array.id_movie)
        val nama = resources.getStringArray(R.array.nama)
        val comment = resources.getStringArray(R.array.comment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()


    }
}